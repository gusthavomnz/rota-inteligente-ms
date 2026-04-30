package com.gusthavomnz.rota_inteligente.apis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OsrmResponseDTO(
        List<RouteDTO> routes
) {}



/*
Exemplo de retorno de requisição para a OSRM:
- Precisamos do objeto "routes"(que vem em listas pela API). Campos: distance e duration, que estão presentes no RouteDTO da nossa aplicação.
- @JsonIgnoreProperties irá descartar todas as outras coisas.

{"code":"Ok",
"routes":[{"legs":[{"steps":[],"weight":6854.5,"summary":"","duration":6854.5,"distance":115169.1}],"weight_name":"routability","weight":6854.5,"duration":6854.5,"distance":115169.1}],"waypoints":[{"hint":"DSjhhEdLFYcFAAAAuQAAACwAAABdAAAACkN_QHEhAEMYpfRBPmmBQgUAAAC5AAAALAAAAF0AAABlkQAAZ2PJ_eUpV_9nY8n95SlX_wIAvw0AAAAA","location":[-37.133465,-11.064859],"name":"Rua B","distance":0},{"hint":"cvzdjf___39MAAAAewAAAAAAAAALAAAABnpUQvoBAEIAAAAArPH9QEwAAAB7AAAAAAAAAAsAAABlkQAAehS__cslXP9AFL_9NyVc_wAAPxIAAAAA","location":[-37.80903,-10.738229],"name":"Praça Barão de Santa Rosa","distance":17.55710071}]}
 */