package com.reed.integration.controller;

import com.reed.integration.dto.forecast.ForecastWrapperDto;
import com.reed.integration.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    @Autowired
    public ForecastController(final ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<ForecastWrapperDto> getForecast(@PathVariable("city") final String city,
                                                          @RequestParam("days") final int days,
                                                          @RequestParam("aqi") final String aqi,
                                                          @RequestParam("alerts") final String alerts) {
        final ForecastWrapperDto forecast = this.forecastService.getForecastFor(city, days, aqi, alerts);
        return ResponseEntity.ok().body(forecast);
    }
}
