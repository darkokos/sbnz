package com.ftn.sbnz.service.dtos;

import com.ftn.sbnz.model.PowerSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationDto {
    private boolean isCarCharging;
    private PowerSource powerSource;
    private boolean isAcOn;
    private boolean isSpaceHeaterOn;
    private boolean isRadiatorOn;
    private boolean isFloorHeatingOn;
    private boolean isWashingMachineOn;
    private int lightBrightness;
    private boolean isBoilerOn;
    private boolean isDryerOn;
    private boolean isAirPurifierOn;
    private boolean isDishWasherOn;
}
