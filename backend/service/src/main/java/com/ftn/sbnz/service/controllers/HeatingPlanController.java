package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.HeatingGoalDto;
import com.ftn.sbnz.service.dtos.HeatingPlanDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/heating")
public class HeatingPlanController {
    @PostMapping
    public HeatingGoalDto postHeatingPlan(@RequestBody HeatingPlanDto heatingPlanDto) {
        return null;
    }
}
