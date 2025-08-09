package com.fidenz.weather_api.service;

import com.fidenz.weather_api.controller.ResponseDTO.WeatherResponseDTO;
import com.fidenz.weather_api.model.City;

import java.util.List;
import java.util.Map;

public interface WeatherService {

    List<WeatherResponseDTO> getWeatherData();
}
