package com.reed.integration.controller;

import com.reed.integration.dto.timezone.TimeZone;
import com.reed.integration.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timezone")
public class TimeZoneController {

    private final TimeZoneService timeZoneService;

    @Autowired
    public TimeZoneController(final TimeZoneService timeZoneService) {
        this.timeZoneService = timeZoneService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<TimeZone> getTimeZone(@PathVariable("city") final String city) {
        final TimeZone timeZone = this.timeZoneService.getTimeZone(city);
        return ResponseEntity.ok().body(timeZone);
    }
}
