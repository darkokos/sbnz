package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.exceptions.RestException;
import com.ftn.sbnz.service.repositories.HomeStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HomeStateService {
    private final HomeStateRepository homeStateRepository;

    @Autowired
    public HomeStateService(HomeStateRepository homeStateRepository) {
        this.homeStateRepository = homeStateRepository;
    }

    public RecommendationDto getRecommendation() {
        RecommendationDto recommendationDto = new RecommendationDto();
        recommendationDto.setCarCharging(this.homeStateRepository.getElectricCarCharger().getIsCharging());
        recommendationDto.setPowerSource(this.homeStateRepository.getHome().getPowerSource());
        recommendationDto.setAcOn(this.homeStateRepository.getAirConditioner().isOn());
        recommendationDto.setSpaceHeaterOn(this.homeStateRepository.getSpaceHeater().isOn());
        recommendationDto.setRadiatorOn(this.homeStateRepository.getRadiator().isOn());
        recommendationDto.setFloorHeatingOn(this.homeStateRepository.getFloorHeater().isOn());
        recommendationDto.setWashingMachineOn(this.homeStateRepository.getWashingMachine().isOn());
        recommendationDto.setLightBrightness(this.homeStateRepository.getLights().getBrightness());
        recommendationDto.setBoilerOn(this.homeStateRepository.getBoiler().isOn());
        recommendationDto.setDryerOn(this.homeStateRepository.getDryer().isOn());
        recommendationDto.setAirPurifierOn(this.homeStateRepository.getAirConditioner().isOn());
        recommendationDto.setDishWasherOn(this.homeStateRepository.getDishWasher().isOn());
        return recommendationDto;
    }

    public RecommendationDto updateAcState(AirConditionerDto airConditionerDto) {
        if (airConditionerDto.getTargetTemperature() < -20 || airConditionerDto.getTargetTemperature() > 50) {
            throw new RestException(HttpStatus.BAD_REQUEST, "AC temperature is too low/high");
        }
        AirConditioner airConditioner = this.homeStateRepository.getAirConditioner();
        airConditioner.setOn(airConditionerDto.isOn());
        airConditioner.setTargetTemperature(airConditionerDto.getTargetTemperature());

        this.homeStateRepository.setAirConditioner(airConditioner);

        return getRecommendation();
    }

    public RecommendationDto updateAirPurifierState(AirPurifierDTO purifierDTO)  {
        AirPurifier purifier = this.homeStateRepository.getAirPurifier();
        purifier.setOn(purifierDTO.isOn());
        this.homeStateRepository.setAirPurifier(purifier);
        return getRecommendation();
    }

    public RecommendationDto updateBoilerState(BoilerDto boilerDto) {
        Boiler boiler = this.homeStateRepository.getBoiler();
        boiler.setOn(boilerDto.isOn());
        this.homeStateRepository.setBoiler(boiler);
        return getRecommendation();
    }

    public RecommendationDto updateDishWasherState(DishWasherDTO dishWasherDTO) {
        DishWasher dishWasher = this.homeStateRepository.getDishWasher();
        dishWasher.setOn(dishWasherDTO.isOn());
        dishWasher.setLoaded(dishWasherDTO.isLoaded());
        this.homeStateRepository.setDishWasher(dishWasher);
        return getRecommendation();
    }

    public RecommendationDto updateDryerState(DryerDTO dryerDTO) {
        Dryer dryer = this.homeStateRepository.getDryer();
        dryer.setLoaded(dryerDTO.isLoaded());
        dryer.setOn(dryerDTO.isOn());
        this.homeStateRepository.setDryer(dryer);
        return getRecommendation();
    }

    public RecommendationDto updateElectricCarChargerState(ElectricCarChargerDto electricCarChargerDto) {
        ElectricCarCharger charger = this.homeStateRepository.getElectricCarCharger();
        charger.setIsCharging(electricCarChargerDto.getIsCharging());
        this.homeStateRepository.setElectricCarCharger(charger);
        return getRecommendation();
    }

    public RecommendationDto updateFloorHeaterState(FloorHeaterDto floorHeaterDto) {
        FloorHeater floorHeater = this.homeStateRepository.getFloorHeater();
        floorHeater.setOn(floorHeaterDto.isOn());
        this.homeStateRepository.setFloorHeater(floorHeater);
        return getRecommendation();
    }

    public RecommendationDto updateHomeState(HomeDto homeDto) {
        if (homeDto.getDesiredTemp() < -20 || homeDto.getDesiredTemp() > 50)  {
            throw new RestException(HttpStatus.BAD_REQUEST, "Desired temperature has to be in range [-20, 50]");
        }
        if (homeDto.getCurrentConsumption() < 0) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Current consumption cannot be negative");
        }
        if (homeDto.getNumberOfPresentResidents() < 0) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Number of present residents cannot be negative");
        }
        Home home = this.homeStateRepository.getHome();
        home.setCurrentConsumption(homeDto.getCurrentConsumption());
        home.setDesiredTemp(homeDto.getDesiredTemp());
        home.setNumberOfPresentResidents(homeDto.getNumberOfPresentResidents());
        home.setPowerSource(homeDto.getPowerSource());
        home.setConsumptionProfile(homeDto.getConsumptionProfile());

        this.homeStateRepository.setHome(home);
        return getRecommendation();
    }

    public RecommendationDto updateLightsState(LightsDto lightsDto) {
        Lights lights = this.homeStateRepository.getLights();
        lights.setBrightness(lightsDto.getBrightness());
        this.homeStateRepository.setLights(lights);
        return getRecommendation();
    }

    public RecommendationDto updateRadiatorState(RadiatorDto radiatorDto) {
        Radiator radiator = this.homeStateRepository.getRadiator();
        radiator.setOn(radiatorDto.isOn());
        this.homeStateRepository.setRadiator(radiator);
        return getRecommendation();
    }

    public RecommendationDto updateSolarGeneratorState(SolarGeneratorDto solarGeneratorDto) {
        if (solarGeneratorDto.getCurrentBatteryCharge() < 0 || solarGeneratorDto.getCurrentBatteryCharge() > 100) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Current battery charge has to be in range [0, 100]");
        }
        SolarGenerator solarGenerator = this.homeStateRepository.getSolarGenerator();
        solarGenerator.setCurrentBatteryCharge(solarGeneratorDto.getCurrentBatteryCharge());
        solarGenerator.setProduction(solarGeneratorDto.getProduction());
        this.homeStateRepository.setSolarGenerator(solarGenerator);
        return getRecommendation();
    }

    public RecommendationDto updateSpaceHeaterState(SpaceHeaterDto spaceHeaterDto) {
        SpaceHeater spaceHeater = this.homeStateRepository.getSpaceHeater();
        spaceHeater.setOn(spaceHeaterDto.isOn());
        this.homeStateRepository.setSpaceHeater(spaceHeater);
        return getRecommendation();
    }

    public RecommendationDto updateWashingMachineState(WashingMachineDto washingMachineDto) {
        WashingMachine washingMachine = this.homeStateRepository.getWashingMachine();
        washingMachine.setOn(washingMachineDto.isOn());
        this.homeStateRepository.setWashingMachine(washingMachine);
        return getRecommendation();
    }
}
