# Rota Inteligente API

Microsserviço de precificação de frete baseado em **rotas rodoviárias reais**. Diferente de calculadoras que usam distância em linha reta, o sistema integra um pipeline de múltiplas APIs para garantir a geolocalização e o roteamento, refletindo a realidade da malha viária brasileira.

## Requisitos Funcionais

**Cadastros**
- RF01 — Cadastrar, consultar, atualizar e desativar Centros de Distribuição com nome, coordenadas, valor por KM e taxa de despacho
- RF02 — Cadastrar produtos com nome e peso (o peso define o multiplicador de custo)
- RF03 — Associar produtos a CDs com quantidade disponível por unidade

**Inteligência e Integração (Pipeline de Resiliência)**
- **RF04 — Converter CEP em coordenadas:** O sistema utiliza a **BrasilAPI** como fonte primária. Como esta API apresenta ausência de coordenadas na maioria dos CEPs fora de grandes capitais, o sistema detecta campos nulos e aciona automaticamente o **Nominatim (OpenStreetMap)** para realizar o geocoding via busca textual (Rua/Cidade/Estado).
- **RF05 — Calcular a distância real por estradas:** Utiliza o motor **OSRM** para obter a quilometragem exata entre o CD e o destino final.
- **RF06 — Selecionar automaticamente o CD:** Escolha baseada em estoque suficiente e **menor distância real** (rodoviária) até o destino.

**Negócio e Transação**
- RF07 — Calcular o frete aplicando a fórmula: `(Distância_km × ValorKM × MultiplicadorPeso) + TaxaDespacho` — MultiplicadorPeso: 1.0 para < 10 kg e 1.2 para >= 10 kg
- RF08 — Reduzir o estoque do CD selecionado ao confirmar a entrega
- RF09 — Persistir valor cobrado, distância e data no momento da venda, imutável para auditoria futura

**Gerencial**
- RF10 — Listar todas as entregas com valor, distância e CD de origem para fechamento financeiro

---

## O Problema dos Dados Nulos
Em muitas regiões do Brasil (especialmente cidades do interior ou áreas com CEP único), as APIs de consulta de CEP não retornam coordenadas geográficas. Para evitar falhas no cálculo de frete, este projeto implementa um **fluxo de orquestração resiliente** que busca dados alternativos quando a fonte primária falha.

---

## Fluxo de Orquestração das APIs

O sistema não consome as APIs de forma isolada, mas sim através de uma lógica de **fallback**:

1.  **Entrada:** O usuário informa o CEP de destino.
2.  **Etapa 1 (BrasilAPI):** Busca os dados do endereço. Se retornar `latitude` e `longitude`, o sistema pula para a Etapa 3.
3.  **Etapa 2 (Nominatim - Fallback):** Caso as coordenadas venham nulas (cenário comum), o sistema extrai o nome da rua e cidade da BrasilAPI e consulta o Nominatim para converter esse endereço em pontos geográficos.
4.  **Etapa 3 (OSRM):** Com as coordenadas de origem (CD) e destino final em mãos, o motor OSRM calcula a rota asfáltica real.


---

## APIs Externas

### BrasilAPI — Geolocalização por CEP
Converte o CEP do destinatário em coordenadas de latitude e longitude.

- **Documentação:** https://brasilapi.com.br/docs#tag/CEP-V2
- **Endpoint:** `GET https://brasilapi.com.br/api/cep/v2/{cep}`
- **Gratuita, sem autenticação**

```json

{ "cep": "01310-100", "latitude": -23.5617, "longitude": -46.6561 }
```

### Nominatim — Geocoding Fallback
Utilizado para converter endereços textuais em coordenadas quando a BrasilAPI falha.
- **Endpoint:** `GET https://nominatim.openstreetmap.org/search?format=json`

```json
{
"lat": "-10.9115890",
"lon": "-37.0545059",
"display_name": "Rua Laranjeiras, Centro, Aracaju, Sergipe, Brasil",
"importance": 0.05339
}
```

### OSRM — Roteamento Rodoviário Real
Calcula a distância exata em quilômetros percorridos por estradas entre dois pontos geográficos.

- **Documentação:** http://project-osrm.org
- **Endpoint:** `GET http://router.project-osrm.org/route/v1/driving/{lon1},{lat1};{lon2},{lat2}`
- **Gratuita, sem autenticação — dados do OpenStreetMap**

```json

{ "routes": [{ "distance": 287400 }] }  
```

---

## Stack

`Java 17` · `Spring Boot 3` · `SQL Server` · `OpenFeign` · `Flyway`

---

## Endpoints

```
POST  /api/deliveries/calculate     # Calcula frete, baixa estoque e persiste entrega
GET   /api/deliveries               # Relatório gerencial de entregas

POST  /api/products
GET   /api/products

POST  /api/distribution-centers
GET   /api/distribution-centers

POST  /api/stocks
GET   /api/stocks/product/{productId}
```

![Diagrama UML](rota-inteligente/docs/images/frete-inteligente-uml.png)

