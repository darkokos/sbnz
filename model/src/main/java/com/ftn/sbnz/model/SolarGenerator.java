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

    // percentage
    private Double currentBatteryCharge;
}
