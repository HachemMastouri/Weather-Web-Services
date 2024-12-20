package com.example.GraphQL.Service;

import com.example.GraphQL.Entity.Weather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private final String apiKey = "Put_Your_API_Key_HERE";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public Weather getCurrentWeather(String city) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                city, apiKey
        );

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());

                double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
                int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
                double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
                String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

                return new Weather(city, temperature, humidity, windSpeed, description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Weather(city, 0, 0, 0, "Error fetching current weather");
    }

    public List<Weather> getWeatherForecast(String city) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric",
                city, apiKey
        );

        List<Weather> forecastList = new ArrayList<>();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                JSONArray list = jsonResponse.getJSONArray("list");

                for (int i = 0; i < list.length(); i += 8) {
                    JSONObject day = list.getJSONObject(i);
                    double temperature = day.getJSONObject("main").getDouble("temp");
                    int humidity = day.getJSONObject("main").getInt("humidity");
                    double windSpeed = day.getJSONObject("wind").getDouble("speed");
                    String description = day.getJSONArray("weather").getJSONObject(0).getString("description");

                    forecastList.add(new Weather(city, temperature, humidity, windSpeed, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forecastList;
    }
}
