package com.reed.integration.service;

import com.reed.integration.dto.timezone.TimeZone;

public interface TimeZoneService {

    TimeZone getTimeZone(final String city);

}
