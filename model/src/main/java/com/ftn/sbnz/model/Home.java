package com.ftn.sbnz.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Home implements Serializable {
    private PowerSource powerSource;

    // in kWh
    private Double currentConsumption;

    private Integer numberOfPresentResidents;
    private ConsumptionProfile consumptionProfile;
    private Double desiredTemp;
}
