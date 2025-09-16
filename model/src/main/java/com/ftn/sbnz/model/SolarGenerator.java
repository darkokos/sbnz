package com.ftn.sbnz.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class SolarGenerator implements Serializable {
    // in kWh
    private Double production;

    // mAh
    public static Double totalBatteryCapacity = 1000.0;

    // percentage
    private Double currentBatteryCharge;
}
