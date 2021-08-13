package com.reed.integration.service.impl;

import com.reed.integration.dto.search.Search;
import com.reed.integration.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.reed.integration.utils.UriUtils.*;
import static com.reed.integration.utils.ValidationUtils.checkArgs;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${weather-api.key}")
    private String apiKey;

    @Value("${weather-api.url}")
    private String url;

    @Value("${weather-api.search-api-format}")
    private String currentSearchApiFormat;

    private final RestTemplate restTemplate;

    @Autowired
    public SearchServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Search> search(final String city) {
        checkArgs(city);
        final Map<String, Object> params = params(
                Tuple.of(KEY, this.apiKey),
                Tuple.of(QUERY, city)
        );
        final URI uri = buildUri(this.url, this.currentSearchApiFormat, params);
        List<Search> result = new ArrayList<>();
        try {
            final ResponseEntity<?> responseEntity = this.restTemplate.getForEntity(uri, List.class);
            final List<Map<String, Object>> body = (ArrayList<Map<String, Object>>) responseEntity.getBody();
            if (body != null) {
                for (final Map<String, Object> map : body) {
                    final Search search = new Search();
                    setObjectValuesReflectively(map, search);
                    result.add(search);
                }
            }
        } catch (Exception e) {
            log.error("Error getting a search object, the reason is: {}", e.getMessage());
            result = Collections.emptyList();
        }
        return result;
    }

    private void setObjectValuesReflectively(final Map<String, Object> map, final Search search) {
        for (final Map.Entry<String, Object> entry : map.entrySet()) {
            final Field[] fields = search.getClass().getDeclaredFields();
            for (final Field field : fields) {
                if (field.getName().equals(entry.getKey())) {
                    try {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        field.set(search, entry.getValue());
                        break;
                    } catch (IllegalAccessException e) {
                        log.error("Field '{}' is not accessible", field.getName());
                    }
                }
            }
        }
    }
}
