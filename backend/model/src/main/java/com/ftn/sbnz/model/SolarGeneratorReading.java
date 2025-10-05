package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SolarGeneratorReading {
    // In kWh, since last reading
    private double generatedPower;
    private Date timestamp;
}
