package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.*;
import lombok.Getter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReadingRepository {
    private final KieSession kieSession;

    private final FactHandle airQualityReadingHandle;
    @Getter
    private AirQualityReading airQualityReading;

    private final FactHandle solarGeneratorReadingHandle;
    @Getter
    private SolarGeneratorReading solarGeneratorReading;

    private final FactHandle temperatureReadingHandle;
    @Getter
    private TemperatureReading temperatureReading;

    private final FactHandle timeReadingHandle;
    @Getter
    private TimeReading timeReading;

    private final FactHandle weatherReadingHandle;
    @Getter
    private WeatherReading weatherReading;

    @Autowired
    public ReadingRepository(KieSession kieSession) {
        this.kieSession = kieSession;
        // TODO: init sane defaults
        airQualityReadingHandle = this.kieSession.insert(airQualityReading);
        solarGeneratorReadingHandle = this.kieSession.insert(solarGeneratorReading);
        temperatureReadingHandle = this.kieSession.insert(temperatureReading);
        timeReadingHandle = this.kieSession.insert(timeReading);
        weatherReadingHandle = this.kieSession.insert(weatherReading);
    }

    public void setAirQualityReading(AirQualityReading reading) {
        this.airQualityReading = reading;
        this.kieSession.update(airQualityReadingHandle, reading);
        this.kieSession.fireAllRules();
    }

    public void setTimeReading(TimeReading reading) {
        this.timeReading = reading;
        this.kieSession.update(timeReadingHandle, reading);
        this.kieSession.fireAllRules();
    }

    public void setSolarGeneratorReading(SolarGeneratorReading reading) {
        this.solarGeneratorReading = reading;
        this.kieSession.update(solarGeneratorReadingHandle, reading);
        this.kieSession.fireAllRules();
    }

    public void setTemperatureReading(TemperatureReading reading) {
        this.temperatureReading = reading;
        this.kieSession.update(temperatureReadingHandle, reading);
        this.kieSession.fireAllRules();
    }

    public void setWeatherReading(WeatherReading reading) {
        this.weatherReading = reading;
        this.kieSession.update(weatherReadingHandle, reading);
        this.kieSession.fireAllRules();
    }
}

