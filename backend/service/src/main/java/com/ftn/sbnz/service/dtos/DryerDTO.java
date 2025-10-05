package com.ftn.sbnz.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DryerDTO {
    private boolean isOn;
    private boolean isLoaded;
}
