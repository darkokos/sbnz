package com.ftn.sbnz.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class ElectricCar implements Serializable {
    private Boolean isCharging;
}
