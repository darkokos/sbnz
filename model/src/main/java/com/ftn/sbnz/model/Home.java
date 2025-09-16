package com.ftn.sbnz.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Home implements Serializable {
    private HomeProfile profile;

    // in kWh
    private Double currentConsumption;

}
