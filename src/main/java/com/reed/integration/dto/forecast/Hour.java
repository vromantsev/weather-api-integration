package com.reed.integration.dto.forecast;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reed.integration.dto.weather.Condition;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hour {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;
    private Double temp_c;
    private Integer is_day;
    private Condition condition;
    private Double wind_kph;
    private Integer humidity;
    private Integer cloud;
    private Integer will_it_rain;
    private Integer chance_of_rain;
    private Integer will_it_snow;
    private Integer chance_of_snow;
}
