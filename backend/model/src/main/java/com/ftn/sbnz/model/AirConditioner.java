package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AirConditioner {
    private boolean isOn;
    private double targetTemperature;
}
