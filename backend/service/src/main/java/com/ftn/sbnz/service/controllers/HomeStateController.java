package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.services.HomeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HomeStateController {
    private final HomeStateService homeStateService;

    @Autowired
    public HomeStateController(HomeStateService homeStateService) {
        this.homeStateService = homeStateService;
    }

    @GetMapping
    public RecommendationDto getHomeState() {
        return null;
    }

    @PutMapping("/ac")
    public RecommendationDto putAcState(@RequestBody AirConditionerDto airConditionerDto) {
        return homeStateService.updateAcState(airConditionerDto);
    }

    @PutMapping("/boiler")
    public RecommendationDto putBoilerState(@RequestBody BoilerDto boilerDto) {
        return null;
    }

    @PutMapping("/car-charger")
    public RecommendationDto putElectricCarChargerState(@RequestBody ElectricCarChargerDto electricCarChargerDto) {
        return null;
    }

    @PutMapping("/price-list")
    public RecommendationDto putElectricityPriceListState(@RequestBody ElectricityPriceListDto electricityPriceListDto) {
        return null;
    }

    @PutMapping("/floor-heater")
    public RecommendationDto putFloorHeaterState(@RequestBody FloorHeaterDto floorHeaterDto) {
        return null;
    }

    @PutMapping("/home")
    public RecommendationDto putHomeState(@RequestBody HomeDto homeDto) {
        return null;
    }

    @PutMapping("/lights")
    public RecommendationDto putLightsState(@RequestBody LightsDto lightsDto) {
        return null;
    }

    @PutMapping("/radiator")
    public RecommendationDto putRadiatorState(@RequestBody RadiatorDto radiatorDto) {
        return null;
    }

    @PutMapping("/solar-generator")
    public RecommendationDto putSolarGeneratorState(@RequestBody SolarGeneratorDto solarGeneratorDto) {
        return null;
    }

    @PutMapping("/space-heater")
    public RecommendationDto putSpaceHeaterState(@RequestBody SpaceHeaterDto spaceHeaterDto) {
        return null;
    }

    @PutMapping("/washing-machine")
    public RecommendationDto putWashingMachineState(@RequestBody WashingMachineDto washingMachineDto) {
        return null;
    }

    @PutMapping("/window-blinds")
    public RecommendationDto putWindowBlindsState(@RequestBody WindowBlindsDto windowBlindsDto) {
        return null;
    }
}
