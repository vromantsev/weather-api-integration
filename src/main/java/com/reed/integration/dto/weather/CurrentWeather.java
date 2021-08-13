package com.reed.integration.dto.weather;

import com.reed.integration.dto.forecast.AirQuality;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentWeather {
    private Double temp_c;
    private Integer is_day;
    private Condition condition;
    private Double wind_kph;
    private String wind_dir;
    private Integer humidity;
    private Integer cloud;
    private AirQuality air_quality;
}
