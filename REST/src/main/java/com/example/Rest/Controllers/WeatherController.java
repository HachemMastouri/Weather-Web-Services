package com.example.Rest.Controllers;

import com.example.Rest.Entities.Weather;
import com.example.Rest.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public Weather getCurrentWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }

    @GetMapping("/forecast/{city}")
    public List<Weather> getWeatherForecast(@PathVariable String city) {
        return weatherService.getWeatherForecast(city);
    }
}
