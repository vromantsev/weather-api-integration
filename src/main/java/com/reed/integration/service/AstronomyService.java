package com.reed.integration.service;

import com.reed.integration.dto.astronomy.AstronomyWrapperDto;

public interface AstronomyService {

    AstronomyWrapperDto getAstronomy(final String city, final String date);

}
