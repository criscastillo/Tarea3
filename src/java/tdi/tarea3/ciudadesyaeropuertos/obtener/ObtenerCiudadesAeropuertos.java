/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdi.tarea3.ciudadesyaeropuertos.obtener;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author criscastillo
 */
@WebService(serviceName = "ObtenerCiudadesAeropuertos")
public class ObtenerCiudadesAeropuertos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtener")
    public String[] obtenerCiudadesAeropuertos(@WebParam(name = "pais") String pais) {
        String[] respuesta = new String[2];
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        
        respuesta[0] = gwSoap.getCitiesByCountry(pais);
        
        Airport air = new Airport();
        AirportSoap airSoap = air.getAirportSoap();
        
        respuesta[1] = airSoap.getAirportInformationByCountry(pais);
        
        return respuesta;
    }
}
