package com.gusthavomnz.rota_inteligente.integration.osrmAPI.port;

public interface OsrmPort {
    String  formatCoords(String lat1, String lon1, String lat2, String lon2);
    Double sendRequestRouteOsrm (String coords);
}
