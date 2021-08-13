package com.reed.integration.service;

import com.reed.integration.dto.weather.CityWeatherDto;

public interface WeatherService {

    CityWeatherDto getCityWeather(final String city);

}
