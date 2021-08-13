package com.reed.integration.service.impl;

import com.reed.integration.dto.astronomy.AstronomyWrapperDto;
import com.reed.integration.service.AstronomyService;
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
import static com.reed.integration.utils.ValidationUtils.checkDateFormat;

@Slf4j
@Service
public class AstronomyServiceImpl implements AstronomyService {

    @Value("${weather-api.key}")
    private String apiKey;

    @Value("${weather-api.url}")
    private String url;

    @Value("${weather-api.astronomy-api-format}")
    private String currentAstronomyApiFormat;

    private final RestTemplate restTemplate;

    @Autowired
    public AstronomyServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AstronomyWrapperDto getAstronomy(final String city, final String date) {
        checkArgs(city, date);
        checkDateFormat(date);
        final Map<String, Object> params = params(
                Tuple.of(KEY, this.apiKey),
                Tuple.of(QUERY, city),
                Tuple.of(DATE, date)
        );
        final URI uri = buildUri(this.url, this.currentAstronomyApiFormat, params);
        AstronomyWrapperDto result = null;
        try {
            final ResponseEntity<AstronomyWrapperDto> responseEntity = this.restTemplate.getForEntity(uri, AstronomyWrapperDto.class);
            result = responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error getting astronomy for city='{}' and date='{}', the reason is: {}", city, date, e.getMessage());
            result = new AstronomyWrapperDto();
        }
        return result;
    }
}
