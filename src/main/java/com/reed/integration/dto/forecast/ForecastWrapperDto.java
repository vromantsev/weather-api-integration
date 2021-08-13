package com.reed.integration.dto.forecast;

import com.reed.integration.dto.weather.CurrentWeather;
import com.reed.integration.dto.weather.Location;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForecastWrapperDto {
    private Location location;
    private CurrentWeather current;
    private Forecast forecast;
}
