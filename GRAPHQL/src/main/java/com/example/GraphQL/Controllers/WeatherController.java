package com.example.GraphQL.Controllers;

import com.example.GraphQL.Entity.Weather;
import com.example.GraphQL.Service.WeatherService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WeatherController {
    private final WeatherService weatherService = new WeatherService();

    @QueryMapping
    public Weather currentWeather(@Argument String city) {
        return weatherService.getCurrentWeather(city);
    }

    @QueryMapping
    public List<Weather> weatherForecast(@Argument String city) {
        return weatherService.getWeatherForecast(city);
    }
}
