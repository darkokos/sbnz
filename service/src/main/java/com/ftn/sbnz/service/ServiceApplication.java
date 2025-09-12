package com.ftn.sbnz.service;

import org.springframework.context.annotation.Bean;
import org.kie.api.runtime.KieContainer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(ServiceApplication.class, args);
	}

}
