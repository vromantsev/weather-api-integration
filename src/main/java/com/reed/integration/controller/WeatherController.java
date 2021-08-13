package com.reed.integration.controller;

import com.reed.integration.dto.weather.CityWeatherDto;
import com.reed.integration.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<CityWeatherDto> getWeatherForCity(@PathVariable("city") final String city) {
        final CityWeatherDto cityWeather = this.weatherService.getCityWeather(city);
        return ResponseEntity.ok().body(cityWeather);
    }
}
