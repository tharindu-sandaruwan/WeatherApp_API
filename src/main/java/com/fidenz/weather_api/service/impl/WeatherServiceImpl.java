package com.fidenz.weather_api.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidenz.weather_api.controller.ResponseDTO.WeatherResponseDTO;
import com.fidenz.weather_api.service.CityService;
import com.fidenz.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "8227c35669ce721137a2efbdf541de8f";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityService cityService;

    public List<WeatherResponseDTO> getWeatherData() {

        List<String> cityCodes = cityService.getCityCodes();
        List<WeatherResponseDTO> weatherDataList = new ArrayList<>();

        for (String cityCode : cityCodes) {
            String url = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                    .queryParam("id", cityCode)
                    .queryParam("appid", API_KEY)
                    .queryParam("units", "metric")
                    .toUriString();

            try {
                JsonNode root = restTemplate.getForObject(url, JsonNode.class);

                if (root != null) {

                    WeatherResponseDTO weatherResponse = new WeatherResponseDTO();
                    weatherResponse.setName(root.path("name").asText());

                    JsonNode weatherArray = root.path("weather");
                    if (weatherArray.isArray() && !weatherArray.isEmpty()) {
                        weatherResponse.setDescription(weatherArray.get(0).path("description").asText());
                    }

                    weatherResponse.setTemp(String.valueOf(root.path("main").path("temp").asDouble()));

                    weatherDataList.add(weatherResponse);
                }
            } catch (Exception e) {
                System.err.println("Could not retrieve weather data for city code: " + cityCode);
                e.printStackTrace();
            }
        }
        return weatherDataList;
    }
}