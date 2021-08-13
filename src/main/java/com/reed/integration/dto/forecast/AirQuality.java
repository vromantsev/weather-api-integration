package com.reed.integration.dto.forecast;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AirQuality {
    private Double co;
    private Double no2;
    private Double o3;
    private Double so2;
}
