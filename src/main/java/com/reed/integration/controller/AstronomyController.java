package com.reed.integration.controller;

import com.reed.integration.dto.astronomy.AstronomyWrapperDto;
import com.reed.integration.service.AstronomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/astronomy")
public class AstronomyController {

    private final AstronomyService astronomyService;

    @Autowired
    public AstronomyController(final AstronomyService astronomyService) {
        this.astronomyService = astronomyService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<AstronomyWrapperDto> getAstronomy(@PathVariable("city") final String city,
                                                            @RequestParam("dt") final String date) {
        final AstronomyWrapperDto astronomy = this.astronomyService.getAstronomy(city, date);
        return ResponseEntity.ok().body(astronomy);
    }
}
