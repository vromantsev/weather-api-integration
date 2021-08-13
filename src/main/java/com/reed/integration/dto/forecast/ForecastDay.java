package com.reed.integration.dto.forecast;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForecastDay {
    private LocalDate date;
    private Astro astro;
    private List<Hour> hour;
    private Alerts alerts;
}
