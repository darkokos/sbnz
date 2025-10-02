package com.ftn.sbnz.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HeatingPlanDto {
    private double targetTemperature;

    // TODO: How to identify devices?
    private List<String> devices;
    private double gridBudget;
    private double batteryBudget;
}
