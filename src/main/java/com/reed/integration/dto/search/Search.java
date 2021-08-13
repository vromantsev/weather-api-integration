package com.reed.integration.dto.search;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Search {
    private Integer id;
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String url;
}
