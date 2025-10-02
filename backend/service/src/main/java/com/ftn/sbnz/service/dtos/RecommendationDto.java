package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.PowerSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RecommendationDto {
    private boolean isCarCharging;
    private PowerSource powerSource;
    private boolean isAcOn;
    private boolean isSpaceHeaterOn;
    private boolean isRadiatorOn;
    private boolean isFloorHeatingOn;
    private boolean areBlindsDown;
    private boolean isWashingMachineOn;
    private boolean areLightsOn;
    private boolean isBoilerOn;
}
