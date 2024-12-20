package SoapWebService;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "WeatherWS")
public class WeatherService {

    public Weather getWeather(@WebParam(name="city")String city){
        String apiKey = "Put_Your_API_Key_HERE";
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);



                double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
                int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
                double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
                String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
                return new Weather(city, temperature, humidity, windSpeed, description);
            } else {
                System.out.println("Error: " + response.statusCode());
                return new Weather(city, 0, 0, 0, "Error fetching data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Weather(city, 0, 0, 0, "Error fetching data");
        }

    }

    public List<Weather> getForecast(@WebParam(name = "city") String city) {
        String apiKey = "Put_Your_API_Key_HERE";
        String url = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", city, apiKey);
        List<Weather> forecastList = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray forecastArray = jsonResponse.getJSONArray("list");

                for (int i = 0; i < forecastArray.length(); i = i+8) {
                    JSONObject dayForecast = forecastArray.getJSONObject(i);

                    // Extract attributes
                    double temperature = dayForecast.getJSONObject("main").getDouble("temp");
                    int humidity = dayForecast.getJSONObject("main").getInt("humidity");
                    double windSpeed = dayForecast.getJSONObject("wind").getDouble("speed");
                    String description = dayForecast.getJSONArray("weather").getJSONObject(0).getString("description");

                    // Create a Weather object and add it to the list
                    Weather weather = new Weather(city, temperature, humidity, windSpeed, description);
                    forecastList.add(weather);
                }
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forecastList;
    }
}
