package com.reed.integration.service.impl;

import com.reed.integration.dto.weather.CityWeatherDto;
import com.reed.integration.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static com.reed.integration.utils.UriUtils.*;
import static com.reed.integration.utils.ValidationUtils.checkArgs;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather-api.key}")
    private String apiKey;

    @Value("${weather-api.url}")
    private String url;

    @Value("${weather-api.current-api-format}")
    private String currentWeatherApiFormat;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CityWeatherDto getCityWeather(final String city) {
        checkArgs(city);
        final Map<String, Object> params = params(
                Tuple.of(KEY, this.apiKey),
                Tuple.of(QUERY, city)
        );
        final URI uri = buildUri(this.url, this.currentWeatherApiFormat, params);
        CityWeatherDto result = null;
        try {
            final ResponseEntity<CityWeatherDto> responseEntity = this.restTemplate.getForEntity(uri, CityWeatherDto.class);
            result = responseEntity.getBody();
        } catch (Exception e) {
            log.error("Cannot get current weather, the reason is: {}", e.getMessage());
            result = new CityWeatherDto();
        }
        return result;
    }
}
