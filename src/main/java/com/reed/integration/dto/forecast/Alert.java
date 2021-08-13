package com.reed.integration.dto.forecast;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alert {
    private String headline;
    private String msgtype;
    private String severity;
    private String urgency;
    private String areas;
    private String category;
    private String certainty;
    private String event;
    private String note;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private LocalDateTime effective;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private LocalDateTime expires;
    private String desc;
    private String instruction;
}
