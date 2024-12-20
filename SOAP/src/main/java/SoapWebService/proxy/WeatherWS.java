
package SoapWebService.proxy;

import jakarta.xml.ws.*;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;



/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WeatherWS", targetNamespace = "http://SoapWebService/", wsdlLocation = "http://localhost:8080/?WSDL")
public class WeatherWS
    extends Service
{

    private final static URL WEATHERWS_WSDL_LOCATION;
    private final static WebServiceException WEATHERWS_EXCEPTION;
    private final static QName WEATHERWS_QNAME = new QName("http://SoapWebService/", "WeatherWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEATHERWS_WSDL_LOCATION = url;
        WEATHERWS_EXCEPTION = e;
    }

    public WeatherWS() {
        super(__getWsdlLocation(), WEATHERWS_QNAME);
    }

    public WeatherWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEATHERWS_QNAME, features);
    }

    public WeatherWS(URL wsdlLocation) {
        super(wsdlLocation, WEATHERWS_QNAME);
    }

    public WeatherWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEATHERWS_QNAME, features);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WeatherService
     */
    @WebEndpoint(name = "WeatherServicePort")
    public WeatherService getWeatherServicePort() {
        return super.getPort(new QName("http://SoapWebService/", "WeatherServicePort"), WeatherService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherService
     */
    @WebEndpoint(name = "WeatherServicePort")
    public WeatherService getWeatherServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://SoapWebService/", "WeatherServicePort"), WeatherService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEATHERWS_EXCEPTION!= null) {
            throw WEATHERWS_EXCEPTION;
        }
        return WEATHERWS_WSDL_LOCATION;
    }

}