package com.ftn.sbnz.service;

import com.ftn.sbnz.model.ElectricCar;
import com.ftn.sbnz.model.Home;
import com.ftn.sbnz.model.HomeProfile;
import com.ftn.sbnz.model.SolarGenerator;
import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.context.annotation.Bean;
import org.kie.api.runtime.KieContainer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServiceApplication {

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(1000);
        return kContainer;
    }

	public static void main(String[] args) {
		// SpringApplication.run(ServiceApplication.class, args);
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(1000);
        KieSession kieSession = kContainer.newKieSession("smart-home-rules");

        List<String> firedRules = new ArrayList<>();
        kieSession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void afterMatchFired(AfterMatchFiredEvent event) {
               firedRules.add(event.getMatch().getRule().getName());
            }
        });

        // init default state
        Home home = new Home(HomeProfile.GRID, 1000.0);
        SolarGenerator sg = new SolarGenerator(500.0, 100.0);
        ElectricCar ec = new ElectricCar(false);

        FactHandle homeHandle = kieSession.insert(home);
        FactHandle solarHandle = kieSession.insert(sg);
        FactHandle carHandle = kieSession.insert(ec);

        int fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after init: " + fired);

        // solar production exceeds consumption
        home.setCurrentConsumption(250.0);
        kieSession.update(homeHandle, home);

        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after solar production exceeds consumption: " + fired);

        // solar battery too low
        sg.setCurrentBatteryCharge(10.0);
        kieSession.update(solarHandle, sg);
        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after solar battery too low: " + fired);

        // car stops charing when on grid
        ec.setIsCharging(true);
        kieSession.update(carHandle, ec);
        fired = kieSession.fireAllRules();
        System.out.println("Number of fired rules after charging turned off: " + fired);
	}

}
