package com.reed.integration.dto.forecast;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Forecast {
    private List<ForecastDay> forecastday;
}
