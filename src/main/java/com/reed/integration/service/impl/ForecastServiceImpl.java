package com.reed.integration.service.impl;

import com.reed.integration.dto.forecast.ForecastWrapperDto;
import com.reed.integration.exceptions.AppException;
import com.reed.integration.service.ForecastService;
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
public class ForecastServiceImpl implements ForecastService {

    @Value("${weather-api.key}")
    private String apiKey;

    @Value("${weather-api.url}")
    private String url;

    @Value("${weather-api.forecast-api-format}")
    private String currentForecastApiFormat;

    private final RestTemplate restTemplate;

    @Autowired
    public ForecastServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ForecastWrapperDto getForecastFor(final String city, final int days,
                                             final String airQualityData, final String weatherAlertData) {
        if (days <= 0) {
            throw new AppException(String.format("Invalid amount of days '%d'! Days parameter should be >= 1!", days));
        }
        checkArgs(city, airQualityData, weatherAlertData);
        final Map<String, Object> params = params(
                Tuple.of(KEY, this.apiKey),
                Tuple.of(QUERY, city),
                Tuple.of(DAYS, days),
                Tuple.of(AQI, airQualityData),
                Tuple.of(ALERTS, weatherAlertData)
        );
        final URI uri = buildUri(this.url, this.currentForecastApiFormat, params);
        ForecastWrapperDto result = null;
        try {
            final ResponseEntity<ForecastWrapperDto> responseEntity = this.restTemplate.getForEntity(uri, ForecastWrapperDto.class);
            result = responseEntity.getBody();
        } catch (Exception e) {
            log.error("Cannot get forecast for {}, the reason is: {}", city, e.getMessage());
            result = new ForecastWrapperDto();
        }
        return result;
    }
}
