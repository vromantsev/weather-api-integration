package com.reed.integration.service.impl;

import com.reed.integration.dto.timezone.TimeZone;
import com.reed.integration.service.TimeZoneService;
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
public class TimeZoneServiceImpl implements TimeZoneService {

    @Value("${weather-api.key}")
    private String apiKey;

    @Value("${weather-api.url}")
    private String url;

    @Value("${weather-api.timezone-api-format}")
    private String currentTimezoneApiFormat;

    private final RestTemplate restTemplate;

    @Autowired
    public TimeZoneServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TimeZone getTimeZone(final String city) {
        checkArgs(city);
        final Map<String, Object> params = params(
                Tuple.of(KEY, this.apiKey),
                Tuple.of(QUERY, city)
        );
        final URI uri = buildUri(this.url, this.currentTimezoneApiFormat, params);
        TimeZone result = null;
        try {
            final ResponseEntity<TimeZone> responseEntity = this.restTemplate.getForEntity(uri, TimeZone.class);
            result = responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error getting timezone for city '{}', the reason is: {}", city, e.getMessage());
            result = new TimeZone();
        }
        return result;
    }
}
