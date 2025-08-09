package com.fidenz.weather_api.controller;

import com.fidenz.weather_api.controller.ResponseDTO.WeatherResponseDTO;
import com.fidenz.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public List<WeatherResponseDTO> getWeather() {
        return weatherService.getWeatherData();
    }

}