package SoapWebService;




import SoapWebService.proxy.Weather;
import SoapWebService.proxy.WeatherService;
import SoapWebService.proxy.WeatherWS;

import javax.xml.namespace.QName;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SoapClient {
    public static void main(String[] args) throws Exception {
        try {
            URL wsdlURL = new URL("http://localhost:8080/WeatherWS?wsdl");
            QName serviceQName = new QName("http://SoapWebService/", "WeatherWS");
            WeatherWS weatherService = new WeatherWS(wsdlURL, serviceQName);
            WeatherService weatherPort = weatherService.getWeatherServicePort();
            String city = "Tunis";
            Weather weather = weatherPort.getWeather(city);
            System.out.println("Weather for " + city + " on " + LocalDate.now() + ":");
            System.out.println("Temperature: " + weather.getTemperature() + "°C");
            System.out.println("Humidity: " + weather.getHumidity() + "%");
            System.out.println("Wind Speed: " + weather.getWindSpeed() + " m/s");
            System.out.println("Description: " + weather.getDescription());
            System.out.println("------------------------------------------------");
            List<Weather> forecastList = weatherPort.getForecast(city);
            for(int j=0 ; j<forecastList.size();j++){
                System.out.println("Weather for " + city + "on " + LocalDate.now().plusDays(j+1) + ":");
                System.out.println("Temperature: " + forecastList.get(j).getTemperature() + "°C");
                System.out.println("Humidity: " + forecastList.get(j).getHumidity() + "%");
                System.out.println("Wind Speed: " + forecastList.get(j).getWindSpeed() + " m/s");
                System.out.println("Description: " + forecastList.get(j).getDescription());
                System.out.println("------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
