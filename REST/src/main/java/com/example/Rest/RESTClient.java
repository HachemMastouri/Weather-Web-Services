package com.example.Rest;

import com.example.Rest.Entities.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class RESTClient {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8080/api/weather/{city}";
            String city = "Tunis";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class, city);
            Weather weather = response.getBody();
            System.out.println("Rest : ");
            System.out.println("Weather for " + city + " on " + LocalDate.now() + ":");
            System.out.println("Temperature: " + weather.getTemperature() + "°C");
            System.out.println("Humidity: " + weather.getHumidity() + "%");
            System.out.println("Wind Speed: " + weather.getWindSpeed() + " m/s");
            System.out.println("Description: " + weather.getDescription());
            System.out.println("------------------------------------------------");
            String forecastUrl = "http://localhost:8080/api/weather/forecast/{city}";
            ResponseEntity<Weather[]> forecastResponse = restTemplate.getForEntity(forecastUrl, Weather[].class, city);
            Weather[] forecastList = forecastResponse.getBody();
            System.out.println("Rest : ");
            for (int i = 0; i < forecastList.length; i++) {
                Weather dayForecast = forecastList[i];
                System.out.println("Weather for " + city + " on " + LocalDate.now().plusDays(i + 1) + ":");
                System.out.println("Temperature: " + dayForecast.getTemperature() + "°C");
                System.out.println("Humidity: " + dayForecast.getHumidity() + "%");
                System.out.println("Wind Speed: " + dayForecast.getWindSpeed() + " m/s");
                System.out.println("Description: " + dayForecast.getDescription());
                System.out.println("------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
