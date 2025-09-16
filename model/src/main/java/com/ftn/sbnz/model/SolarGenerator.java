package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class SolarGenerator implements Serializable {
    // in kWh
    private Double production;

    // mAh
    public static Double totalBatteryCapacity = 1000.0;

    // percentage
    private Double currentBatteryCharge;

}
