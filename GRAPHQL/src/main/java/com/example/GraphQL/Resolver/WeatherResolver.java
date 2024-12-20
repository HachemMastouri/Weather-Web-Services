package com.example.GraphQL.Resolver;

import com.example.GraphQL.Entity.Weather;
import com.example.GraphQL.Service.WeatherService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherResolver implements GraphQLQueryResolver {
    @Autowired
    private WeatherService weatherService;
    public Weather currentWeather(String city) {
        return weatherService.getCurrentWeather(city);
    }
    public List<Weather> weatherForecast(String city) {
        return weatherService.getWeatherForecast(city);
    }
}
