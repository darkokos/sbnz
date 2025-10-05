package com.ftn.sbnz.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AirQualityReadingDTO {
    // 0-100
    private int humidity;
    // 0-100
    private int airQuality;
}
