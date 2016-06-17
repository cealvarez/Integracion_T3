/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.serv;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author camilo
 */
@WebService(serviceName = "servicio")
public class servicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getData")
    public String[] getData(@WebParam(name = "pais") String pais) {
        String[] resultado = new String[2];
        GlobalWeather gw  = new GlobalWeather();
        GlobalWeatherSoap gwsoap = gw.getGlobalWeatherSoap();
        resultado[0]=gwsoap.getCitiesByCountry(pais);

        Airport aer = new Airport();
        AirportSoap aersoap = aer.getAirportSoap();
        
        resultado[1] = aersoap.getAirportInformationByCountry(pais);
                
        return resultado;
    }
}
