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
        SpringApplication.run(ServiceApplication.class, args);
	}
}
