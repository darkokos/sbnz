package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dtos.RecommendationDto;
import lombok.Getter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeStateRepository {
    private final KieSession kieSession;

    private final FactHandle airConditionerHandle;
    @Getter
    private AirConditioner airConditioner;

    private final FactHandle boilerHandle;
    @Getter
    private Boiler boiler;

    private final FactHandle electricCarChargerHandle;
    @Getter
    private ElectricCarCharger electricCarCharger;

    private final FactHandle floorHeaterHandle;
    @Getter
    private FloorHeater floorHeater;

    private final FactHandle homeHandle;
    @Getter
    private Home home;

    private final FactHandle lightsHandle;
    @Getter
    private Lights lights;

    private final FactHandle radiatorHandle;
    @Getter
    private Radiator radiator;

    private final FactHandle solarGeneratorHandle;
    @Getter
    private SolarGenerator solarGenerator;

    private final FactHandle spaceHeaterHandle;
    @Getter
    private SpaceHeater spaceHeater;

    private final FactHandle washingMachineHandle;
    @Getter
    private WashingMachine washingMachine;

    private final FactHandle airPurifierHandle;
    @Getter
    private AirPurifier airPurifier;

    private final FactHandle dishWasherHandle;
    @Getter
    private DishWasher dishWasher;

    private final FactHandle dryerHandle;
    @Getter
    private Dryer dryer;


    @Autowired
    public HomeStateRepository(KieSession kieSession) {
        this.kieSession = kieSession;

        airConditioner = new AirConditioner(false, 20.0);
        boiler = new Boiler(false);
        electricCarCharger = new ElectricCarCharger(false);
        floorHeater = new FloorHeater(false, 20.0);
        home = new Home(PowerSource.GRID, 400.0, 1, ConsumptionProfile.ECO, null);
        lights = new Lights(0);
        radiator = new Radiator(false);
        solarGenerator = new SolarGenerator(150.0, 20.0);
        spaceHeater = new SpaceHeater(false);
        washingMachine = new WashingMachine(false, false);
        airPurifier = new AirPurifier(false);
        dishWasher = new DishWasher(false, false);
        dryer = new Dryer(false, false);

        airConditionerHandle = this.kieSession.insert(airConditioner);
        boilerHandle = this.kieSession.insert(boiler);
        electricCarChargerHandle = this.kieSession.insert(electricCarCharger);
        floorHeaterHandle = this.kieSession.insert(floorHeater);
        homeHandle = this.kieSession.insert(home);
        lightsHandle = this.kieSession.insert(lights);
        radiatorHandle = this.kieSession.insert(radiator);
        solarGeneratorHandle = this.kieSession.insert(solarGenerator);
        spaceHeaterHandle = this.kieSession.insert(spaceHeater);
        washingMachineHandle = this.kieSession.insert(washingMachine);
        airPurifierHandle = this.kieSession.insert(airPurifier);
        dishWasherHandle = this.kieSession.insert(dishWasher);
        dryerHandle = this.kieSession.insert(dryer);
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
        this.kieSession.update(airConditionerHandle, airConditioner);
        this.kieSession.fireAllRules();
    }

    public void setBoiler(Boiler boiler) {
        this.boiler = boiler;
        this.kieSession.update(boilerHandle, boiler);
        this.kieSession.fireAllRules();
    }

    public void setElectricCarCharger(ElectricCarCharger electricCarCharger) {
        this.electricCarCharger = electricCarCharger;
        this.kieSession.update(electricCarChargerHandle, electricCarCharger);
        this.kieSession.fireAllRules();
    }

    public void setFloorHeater(FloorHeater floorHeater) {
        this.floorHeater = floorHeater;
        this.kieSession.update(floorHeaterHandle, floorHeater);
        this.kieSession.fireAllRules();
    }

    public void setHome(Home home) {
        this.home = home;
        this.kieSession.update(homeHandle, home);
        this.kieSession.fireAllRules();
    }

    public void setLights(Lights lights) {
        this.lights = lights;
        this.kieSession.update(lightsHandle, lights);
        this.kieSession.fireAllRules();
    }

    public void setRadiator(Radiator radiator) {
        this.radiator = radiator;
        this.kieSession.update(radiatorHandle, radiator);
        this.kieSession.fireAllRules();
    }

    public void setSolarGenerator(SolarGenerator solarGenerator) {
        this.solarGenerator = solarGenerator;
        this.kieSession.update(solarGeneratorHandle, solarGenerator);
        this.kieSession.fireAllRules();
    }

    public void setSpaceHeater(SpaceHeater spaceHeater) {
        this.spaceHeater = spaceHeater;
        this.kieSession.update(spaceHeaterHandle, spaceHeater);
        this.kieSession.fireAllRules();
    }

    public void setWashingMachine(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
        this.kieSession.update(washingMachineHandle, washingMachine);
        this.kieSession.fireAllRules();
    }

    public void setAirPurifier(AirPurifier purifier) {
        this.airPurifier = purifier;
        this.kieSession.update(airPurifierHandle, airPurifier);
        this.kieSession.fireAllRules();
    }

    public void setDishWasher(DishWasher dishWasher) {
        this.dishWasher = dishWasher;
        this.kieSession.update(dishWasherHandle, dishWasher);
        this.kieSession.fireAllRules();
    }

    public void setDryer(Dryer dryer) {
        this.dryer = dryer;
        this.kieSession.update(dryerHandle, dryer);
        this.kieSession.fireAllRules();
    }
}
