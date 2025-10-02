package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.AirConditioner;
import com.ftn.sbnz.service.dtos.AirConditionerDto;
import com.ftn.sbnz.service.dtos.RecommendationDto;
import com.ftn.sbnz.service.repositories.HomeStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeStateService {
    private final HomeStateRepository homeStateRepository;

    @Autowired
    public HomeStateService(HomeStateRepository homeStateRepository) {
        this.homeStateRepository = homeStateRepository;
    }

    public RecommendationDto getRecommendation() {
        // TODO: Construct DTO from fields obtained from home state repo

        return null;
    }

    public RecommendationDto updateAcState(AirConditionerDto airConditionerDto) {
        // TODO: Validate DTO

        AirConditioner airConditioner = this.homeStateRepository.getAirConditioner();
        airConditioner.setOn(airConditionerDto.isOn());
        airConditioner.setTargetTemperature(airConditionerDto.getTargetTemperature());

        this.homeStateRepository.setAirConditioner(airConditioner);

        return getRecommendation();
    }
}
