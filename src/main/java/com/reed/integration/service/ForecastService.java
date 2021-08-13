package com.reed.integration.service;

import com.reed.integration.dto.forecast.ForecastWrapperDto;

public interface ForecastService {

    ForecastWrapperDto getForecastFor(final String city, final int days,
                                      final String airQualityData, final String weatherAlertData);
}

