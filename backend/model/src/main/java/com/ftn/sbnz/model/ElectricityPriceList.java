package com.ftn.sbnz.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ElectricityPriceList {
    private Double regularPrice;
    private Double nightlyPrice;
    private Integer hourOfSwitchToRegular;
    private Integer hourOfSwitchToNightly;
}
