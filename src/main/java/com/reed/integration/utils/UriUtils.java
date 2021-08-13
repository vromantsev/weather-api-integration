package com.reed.integration.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class UriUtils {

    public static final String KEY = "key";
    public static final String QUERY = "q";
    public static final String DAYS = "days";
    public static final String AQI = "aqi";
    public static final String ALERTS = "alerts";
    public static final String DATE = "dt";

    private UriUtils() {
    }

    public static URI buildUri(final String url, final String api, final Map<String, Object> params) {
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + api);
        params.forEach(builder::queryParam);
        return builder.build().toUri();
    }

    public static Map<String, Object> params(Tuple<String, Object>... params) {
        Map<String, Object> result = null;
        if (params.length >= 1) {
            result = new LinkedHashMap<>();
            for (Tuple<String, Object> tuple : params) {
                result.put(tuple.getKey(), tuple.getValue());
            }
        } else {
            result = Collections.emptyMap();
        }
        return result;
    }

    public static class Tuple<K, V> {
        private K key;
        private V value;

        private Tuple() {}

        private Tuple(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        public static <K, V> Tuple<K, V> of(final K key, final V value) {
            return new Tuple<>(key, value);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
