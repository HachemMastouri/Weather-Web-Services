package SoapWebService;

import jakarta.xml.ws.Endpoint;

public class ServerJaxWS {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/", new WeatherService());
        System.out.println("Service depoloyé avec succés sur l'adresse http://localhost:8080/");
    }
}
