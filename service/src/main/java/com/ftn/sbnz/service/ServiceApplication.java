package com.ftn.sbnz.service;

import com.ftn.sbnz.model.*;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.kie.api.runtime.KieContainer;
import org.kie.api.KieServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

    @Bean
    public KieSession kieSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        return kContainer.newKieSession("smartHomeRulesKS");
    }

	public static void main(String[] args) {
        // TODO: Remove later

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession("smartHomeRulesKS");

        Home home = new Home(
                PowerSource.GRID,
                1000.0,
                0,
                ConsumptionProfile.BALANCED,
                30.0
        );
        SolarGenerator sg = new SolarGenerator(500.0, 100.0);
        ElectricCarCharger ec = new ElectricCarCharger(false);

        FactHandle homeHandle = kieSession.insert(home);
        FactHandle solarHandle = kieSession.insert(sg);
        FactHandle carHandle = kieSession.insert(ec);

        int fired = kieSession.fireAllRules();
        System.out.println("Home state: " + home);
        System.out.println("Solar state: " + sg);
        System.out.println("Car state: " + ec);
        System.out.println("Number of fired rules after init: " + fired);
        System.out.println();

        // solar production exceeds consumption
        home.setCurrentConsumption(250.0);
        kieSession.update(homeHandle, home);
        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after solar production exceeds consumption: " + fired);
        System.out.println("Home state: " + home);
        System.out.println("Solar state: " + sg);
        System.out.println("Car state: " + ec);
        System.out.println();

        // solar battery too low
        sg.setCurrentBatteryCharge(10.0);
        kieSession.update(solarHandle, sg);
        home.setCurrentConsumption(1000.0);
        kieSession.update(homeHandle, home);
        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after solar battery too low: " + fired);
        System.out.println("Home state: " + home);
        System.out.println("Solar state: " + sg);
        System.out.println("Car state: " + ec);
        System.out.println();

        // car stops charging when on grid
        ec.setIsCharging(true);
        kieSession.update(carHandle, ec);
        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after charging turned off: " + fired);
        System.out.println("Home state: " + home);
        System.out.println("Solar state: " + sg);
        System.out.println("Car state: " + ec);
        System.out.println();

        SpringApplication.run(ServiceApplication.class, args);
	}
}
