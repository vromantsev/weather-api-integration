package com.reed.integration.dto.astronomy;

import com.reed.integration.dto.weather.Location;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AstronomyWrapperDto {
    private Location location;
    private Astronomy astronomy;
}
