package com.gusthavomnz.rota_inteligente.apis.adapter;

import com.gusthavomnz.rota_inteligente.integration.osrmAPI.adapter.OsrmAdapter;
import com.gusthavomnz.rota_inteligente.integration.osrmAPI.adapter.OsrmClient;
import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.OsrmResponseDTO;
import com.gusthavomnz.rota_inteligente.integration.osrmAPI.dto.RouteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OsrmAdapterTest {


    @Mock
   private OsrmClient osrmClient;

    @InjectMocks
    private OsrmAdapter osrmAdapter;


    @Test
    void deveRetornarStringFormatada(){
        // Simão Dias:
        String lat1 = "-10.7383767";
        String lon1 = "-37.8090877";
        // Salvador:
        String lat2 = "-12.9722278";
        String lon2 = "-38.4982186";

        String stringFormatada = osrmAdapter.formatCoords(lat1,lon1,lat2,lon2);
        assertEquals("-37.8090877,-10.7383767;-38.4982186,-12.9722278",stringFormatada);
    }

    @Test
    void deveRetornarDistanciaDaOSRM(){
        // Simão Dias <-> Salvador
        String coords = "-37.8090877,-10.7383767;-38.4982186,-12.9722278";

        List<RouteDTO> routeDTOS = new ArrayList<>();

        var route = 10000;
        RouteDTO distancia = new RouteDTO(10000.0);
        routeDTOS.add(distancia);
        OsrmResponseDTO dto = new OsrmResponseDTO(routeDTOS);

        when(osrmClient.getRoute(coords)).thenReturn(dto);
        Double resultado = osrmAdapter.sendRequestRouteOsrm(coords);
        assertEquals(10,resultado,"Caso retorne 10. Conversão de 10.000 metros para KM foi bem sucedida.");

    }

    @Test
    void deveRetornarZeroCasoDeErro(){
        String coords = "coordenada_invalida";
        when(osrmClient.getRoute(anyString())).thenThrow(new RuntimeException("Erro na API OSRM"));
        double resultado = osrmAdapter.sendRequestRouteOsrm(coords);
        assertEquals(0.0,resultado,"Caso a API dê erro, retornará 0");
    }

}

