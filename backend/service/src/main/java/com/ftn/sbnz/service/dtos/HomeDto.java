package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.ConsumptionProfile;
import com.ftn.sbnz.model.PowerSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HomeDto {
    private PowerSource powerSource;
    private double currentConsumption;
    private int numberOfPresentResidents;
    private ConsumptionProfile consumptionProfile;
    private double desiredTemp;
}
