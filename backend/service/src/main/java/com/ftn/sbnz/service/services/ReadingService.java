package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.exceptions.RestException;
import com.ftn.sbnz.service.repositories.HomeStateRepository;
import com.ftn.sbnz.service.repositories.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;
    private final HomeStateRepository homeStateRepository;

    @Autowired
    public ReadingService(ReadingRepository readingRepository, HomeStateRepository homeStateRepository) {
        this.readingRepository = readingRepository;
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

    public RecommendationDto updateAirQualityReading(AirQualityReadingDTO readingDTO) {
        if (readingDTO.getAirQuality() < 0 || readingDTO.getAirQuality() > 100) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Air quality has to be in range [0, 100]");
        }
        if (readingDTO.getHumidity() < 0 || readingDTO.getHumidity() > 100) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Humidity has to be in range [0, 100]");
        }
        AirQualityReading airQualityReading = this.readingRepository.getAirQualityReading();
        airQualityReading.setAirQuality(readingDTO.getAirQuality());
        airQualityReading.setHumidity(readingDTO.getHumidity());
        this.readingRepository.setAirQualityReading(airQualityReading);
        return getRecommendation();
    }

    public RecommendationDto updateTimeReading(TimeReadingDTO readingDTO) {
        if (readingDTO.getHour() < 0 || readingDTO.getHour() > 23) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Hour has to be in range [0, 23]");
        }
        TimeReading timeReading = this.readingRepository.getTimeReading();
        timeReading.setHour(readingDTO.getHour());
        this.readingRepository.setTimeReading(timeReading);
        return getRecommendation();
    }

    public SavedEnergyDto updateSolarGeneratorReading(SolarGeneratorReadingDTO readingDTO) {
        if (readingDTO.getGeneratedPower() < 0) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Generated power cannot be negative");
        }

        this.readingRepository.insertSolarGeneratorReading(
                new SolarGeneratorReading(readingDTO.getGeneratedPower(), new Date())
        );
        return new SavedEnergyDto(this.readingRepository.getSavedEnergy().getSavedEnergy());
    }

    public RecommendationDto updateTemperatureReading(TemperatureReadingDTO readingDTO) {
        TemperatureReading temperatureReading =  this.readingRepository.getTemperatureReading();
        temperatureReading.setTemperature(readingDTO.getTemperature());
        this.readingRepository.setTemperatureReading(temperatureReading);
        return getRecommendation();
    }

    public RecommendationDto updateWeatherReading(WeatherReadingDTO readingDTO) {
        if (readingDTO.getCloudCoverage() < 0 || readingDTO.getCloudCoverage() > 100) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Cloud coverage has to be in range [0, 100]");
        }
        WeatherReading weatherReading = this.readingRepository.getWeatherReading();
        weatherReading.setCloudCoverage(readingDTO.getCloudCoverage());
        this.readingRepository.setWeatherReading(weatherReading);
        return getRecommendation();
    }
}





