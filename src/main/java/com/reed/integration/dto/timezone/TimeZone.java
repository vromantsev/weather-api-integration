package com.reed.integration.dto.timezone;

import com.reed.integration.dto.weather.Location;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeZone {
    private Location location;
}
