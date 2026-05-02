package com.gusthavomnz.rota_inteligente.apis.port;

import com.gusthavomnz.rota_inteligente.apis.dto.RouteDTO;

public interface OsrmPort {
    String  formatCoords(String lat1, String lon1, String lat2, String lon2);
    Double sendRequestRouteOsrm (String coords);
}
