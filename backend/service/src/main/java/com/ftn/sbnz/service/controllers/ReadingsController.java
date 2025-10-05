package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.*;
import com.ftn.sbnz.service.services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/reading")
@RequestMapping
public class ReadingsController {
    private final ReadingService readingService;

    @Autowired
    public ReadingsController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @PutMapping("/air-quality")
    public ResponseEntity<RecommendationDto> putAirQualityReading(@RequestBody AirQualityReadingDTO readingDTO) {
        return new ResponseEntity<>(readingService.updateAirQualityReading(readingDTO), HttpStatus.OK);
    }

    @PutMapping("/time")
    public ResponseEntity<RecommendationDto> putTimeReading(@RequestBody TimeReadingDTO readingDTO) {
        return new ResponseEntity<>(readingService.updateTimeReading(readingDTO), HttpStatus.OK);
    }

    @PutMapping("/solar-generator")
    public ResponseEntity<RecommendationDto> putSolarGeneratorReading(@RequestBody SolarGeneratorReadingDTO readingDTO) {
        return new ResponseEntity<>(readingService.updateSolarGeneratorReading(readingDTO), HttpStatus.OK);
    }

    @PutMapping("/temperature")
    public ResponseEntity<RecommendationDto> putTemperatureReading(@RequestBody TemperatureReadingDTO readingDTO) {
        return new ResponseEntity<>(readingService.updateTemperatureReading(readingDTO), HttpStatus.OK);
    }

    @PutMapping("/weather")
    public ResponseEntity<RecommendationDto> putWeatherReading(@RequestBody WeatherReadingDTO readingDTO) {
        return new ResponseEntity<>(readingService.updateWeatherReading(readingDTO), HttpStatus.OK);
    }
}
