package com.ftn.sbnz.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ElectricityPriceListDto {
    private Double regularPrice;
    private Double nightlyPrice;
    private Integer hourOfSwitchToRegular;
    private Integer hourOfSwitchToNightly;
}
