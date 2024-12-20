
package SoapWebService.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWeather_QNAME = new QName("http://SoapWebService/", "getWeather");
    private final static QName _Weather_QNAME = new QName("http://SoapWebService/", "Weather");
    private final static QName _GetForecast_QNAME = new QName("http://SoapWebService/", "getForecast");
    private final static QName _GetWeatherResponse_QNAME = new QName("http://SoapWebService/", "getWeatherResponse");
    private final static QName _GetForecastResponse_QNAME = new QName("http://SoapWebService/", "getForecastResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Weather }
     * 
     */
    public Weather createWeather() {
        return new Weather();
    }

    /**
     * Create an instance of {@link GetWeather }
     * 
     */
    public GetWeather createGetWeather() {
        return new GetWeather();
    }

    /**
     * Create an instance of {@link GetForecastResponse }
     * 
     */
    public GetForecastResponse createGetForecastResponse() {
        return new GetForecastResponse();
    }

    /**
     * Create an instance of {@link GetForecast }
     * 
     */
    public GetForecast createGetForecast() {
        return new GetForecast();
    }

    /**
     * Create an instance of {@link GetWeatherResponse }
     * 
     */
    public GetWeatherResponse createGetWeatherResponse() {
        return new GetWeatherResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeather }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapWebService/", name = "getWeather")
    public JAXBElement<GetWeather> createGetWeather(GetWeather value) {
        return new JAXBElement<GetWeather>(_GetWeather_QNAME, GetWeather.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Weather }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapWebService/", name = "Weather")
    public JAXBElement<Weather> createWeather(Weather value) {
        return new JAXBElement<Weather>(_Weather_QNAME, Weather.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetForecast }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapWebService/", name = "getForecast")
    public JAXBElement<GetForecast> createGetForecast(GetForecast value) {
        return new JAXBElement<GetForecast>(_GetForecast_QNAME, GetForecast.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeatherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapWebService/", name = "getWeatherResponse")
    public JAXBElement<GetWeatherResponse> createGetWeatherResponse(GetWeatherResponse value) {
        return new JAXBElement<GetWeatherResponse>(_GetWeatherResponse_QNAME, GetWeatherResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetForecastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapWebService/", name = "getForecastResponse")
    public JAXBElement<GetForecastResponse> createGetForecastResponse(GetForecastResponse value) {
        return new JAXBElement<GetForecastResponse>(_GetForecastResponse_QNAME, GetForecastResponse.class, null, value);
    }

}
