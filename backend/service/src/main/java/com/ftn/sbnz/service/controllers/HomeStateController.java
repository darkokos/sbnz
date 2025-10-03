package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.services.HomeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RecommendationDto> getHomeState() {
        return null;
    }

    @PutMapping("/ac")
    public ResponseEntity<RecommendationDto> putAcState(@RequestBody AirConditionerDto airConditionerDto) {
        return new ResponseEntity<>(homeStateService.updateAcState(airConditionerDto), HttpStatus.OK);
    }

    @PutMapping("/boiler")
    public ResponseEntity<RecommendationDto> putBoilerState(@RequestBody BoilerDto boilerDto) {
        return null;
    }

    @PutMapping("/car-charger")
    public ResponseEntity<RecommendationDto> putElectricCarChargerState(@RequestBody ElectricCarChargerDto electricCarChargerDto) {
        return null;
    }

    @PutMapping("/price-list")
    public ResponseEntity<RecommendationDto> putElectricityPriceListState(@RequestBody ElectricityPriceListDto electricityPriceListDto) {
        return null;
    }

    @PutMapping("/floor-heater")
    public ResponseEntity<RecommendationDto> putFloorHeaterState(@RequestBody FloorHeaterDto floorHeaterDto) {
        return null;
    }

    @PutMapping("/home")
    public ResponseEntity<RecommendationDto> putHomeState(@RequestBody HomeDto homeDto) {
        return null;
    }

    @PutMapping("/lights")
    public ResponseEntity<RecommendationDto> putLightsState(@RequestBody LightsDto lightsDto) {
        return null;
    }

    @PutMapping("/radiator")
    public ResponseEntity<RecommendationDto> putRadiatorState(@RequestBody RadiatorDto radiatorDto) {
        return null;
    }

    @PutMapping("/solar-generator")
    public ResponseEntity<RecommendationDto> putSolarGeneratorState(@RequestBody SolarGeneratorDto solarGeneratorDto) {
        return null;
    }

    @PutMapping("/space-heater")
    public ResponseEntity<RecommendationDto> putSpaceHeaterState(@RequestBody SpaceHeaterDto spaceHeaterDto) {
        return null;
    }

    @PutMapping("/washing-machine")
    public ResponseEntity<RecommendationDto> putWashingMachineState(@RequestBody WashingMachineDto washingMachineDto) {
        return null;
    }

    @PutMapping("/window-blinds")
    public ResponseEntity<RecommendationDto> putWindowBlindsState(@RequestBody WindowBlindsDto windowBlindsDto) {
        return null;
    }
}
