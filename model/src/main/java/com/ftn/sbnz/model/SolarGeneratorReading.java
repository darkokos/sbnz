package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SolarGeneratorReading {
    // In kWh, since last reading
    private double generatedPower;
}
