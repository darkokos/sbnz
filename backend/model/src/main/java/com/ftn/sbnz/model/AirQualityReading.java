package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AirQualityReading {
    // 0-100
    private int humidity;
    // 0-100
    private int airQuality;
}
