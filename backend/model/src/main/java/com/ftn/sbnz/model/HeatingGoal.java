package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HeatingGoal {
    private Double targetTemp;
    private Double batteryBudget;
    private Double gridBudget;
}
