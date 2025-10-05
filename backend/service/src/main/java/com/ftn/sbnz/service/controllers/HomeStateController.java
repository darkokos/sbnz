package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.services.HomeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/state")
@RequestMapping
public class HomeStateController {
    private final HomeStateService homeStateService;

    @Autowired
    public HomeStateController(HomeStateService homeStateService) {
        this.homeStateService = homeStateService;
    }

    @GetMapping
    public ResponseEntity<RecommendationDto> getHomeState() {
        return new ResponseEntity<>(homeStateService.getRecommendation(), HttpStatus.OK);
    }

    @PutMapping("/ac")
    public ResponseEntity<RecommendationDto> putAcState(@RequestBody AirConditionerDto airConditionerDto) {
        return new ResponseEntity<>(homeStateService.updateAcState(airConditionerDto), HttpStatus.OK);
    }

    @PutMapping("/boiler")
    public ResponseEntity<RecommendationDto> putBoilerState(@RequestBody BoilerDto boilerDto) {
        return new ResponseEntity<>(homeStateService.updateBoilerState(boilerDto), HttpStatus.OK);
    }

    @PutMapping("/car-charger")
    public ResponseEntity<RecommendationDto> putElectricCarChargerState(@RequestBody ElectricCarChargerDto electricCarChargerDto) {
        return new ResponseEntity<>(homeStateService.updateElectricCarChargerState(electricCarChargerDto), HttpStatus.OK);
    }

    @PutMapping("/floor-heater")
    public ResponseEntity<RecommendationDto> putFloorHeaterState(@RequestBody FloorHeaterDto floorHeaterDto) {
        return new ResponseEntity<>(homeStateService.updateFloorHeaterState(floorHeaterDto), HttpStatus.OK);
    }

    @PutMapping("/home")
    public ResponseEntity<RecommendationDto> putHomeState(@RequestBody HomeDto homeDto) {
        return new ResponseEntity<>(homeStateService.updateHomeState(homeDto), HttpStatus.OK);
    }

    @PutMapping("/lights")
    public ResponseEntity<RecommendationDto> putLightsState(@RequestBody LightsDto lightsDto) {
        return new ResponseEntity<>(homeStateService.updateLightsState(lightsDto), HttpStatus.OK);
    }

    @PutMapping("/radiator")
    public ResponseEntity<RecommendationDto> putRadiatorState(@RequestBody RadiatorDto radiatorDto) {
        return new ResponseEntity<>(homeStateService.updateRadiatorState(radiatorDto), HttpStatus.OK);
    }

    @PutMapping("/solar-generator")
    public ResponseEntity<RecommendationDto> putSolarGeneratorState(@RequestBody SolarGeneratorDto solarGeneratorDto) {
        return new ResponseEntity<>(homeStateService.updateSolarGeneratorState(solarGeneratorDto), HttpStatus.OK);
    }

    @PutMapping("/space-heater")
    public ResponseEntity<RecommendationDto> putSpaceHeaterState(@RequestBody SpaceHeaterDto spaceHeaterDto) {
        return new ResponseEntity<>(homeStateService.updateSpaceHeaterState(spaceHeaterDto), HttpStatus.OK);
    }

    @PutMapping("/washing-machine")
    public ResponseEntity<RecommendationDto> putWashingMachineState(@RequestBody WashingMachineDto washingMachineDto) {
        return new ResponseEntity<>(homeStateService.updateWashingMachineState(washingMachineDto), HttpStatus.OK);
    }

    @PutMapping("/air-purifier")
    public ResponseEntity<RecommendationDto> putAirPurifierState(@RequestBody AirPurifierDTO airPurifierDTO) {
        return new ResponseEntity<>(homeStateService.updateAirPurifierState(airPurifierDTO), HttpStatus.OK);
    }

    @PutMapping("/dish-washer")
    public ResponseEntity<RecommendationDto> putDishWasherState(@RequestBody DishWasherDTO dishWasherDTO) {
        return new ResponseEntity<>(homeStateService.updateDishWasherState(dishWasherDTO), HttpStatus.OK);
    }

    @PutMapping("/dryer")
    public ResponseEntity<RecommendationDto> puyDryerState(@RequestBody DryerDTO dryerDTO) {
        return new ResponseEntity<>(homeStateService.updateDryerState(dryerDTO), HttpStatus.OK);
    }
}
