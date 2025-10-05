package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Lights {
    // 0 - 100
    private int brightness;

    public int suggestedBrightnessForTheHourOfTheDay(int hour) {
        if (hour >= 0 && hour <= 12) {
            return (int) (hour * (100.0/12.0));
        } else {
            return (int) ((24 - hour) * (100.0/12.0));
        }
    }
}
