package com.reed.integration.dto.weather;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Condition {
    private String text;
    private String icon;
    private Integer code;
}
