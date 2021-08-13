package com.reed.integration.dto.weather;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CityWeatherDto {
    private Location location;
    private CurrentWeather current;
}
/*{
    "location": {
        "name": "London",
        "region": "City of London, Greater London",
        "country": "United Kingdom",
        "lat": 51.52,
        "lon": -0.11,
        "tz_id": "Europe/London",
        "localtime_epoch": 1628863592,
        "localtime": "2021-08-13 15:06"
    },
    "current": {
        "last_updated_epoch": 1628859600,
        "last_updated": "2021-08-13 14:00",
        "temp_c": 21.0,
        "temp_f": 69.8,
        "is_day": 1,
        "condition": {
            "text": "Partly cloudy",
            "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png",
            "code": 1003
        },
        "wind_mph": 11.9,
        "wind_kph": 19.1,
        "wind_degree": 230,
        "wind_dir": "SW",
        "pressure_mb": 1021.0,
        "pressure_in": 30.15,
        "precip_mm": 0.0,
        "precip_in": 0.0,
        "humidity": 64,
        "cloud": 75,
        "feelslike_c": 21.0,
        "feelslike_f": 69.8,
        "vis_km": 10.0,
        "vis_miles": 6.0,
        "uv": 5.0,
        "gust_mph": 14.1,
        "gust_kph": 22.7
    }
}*/
