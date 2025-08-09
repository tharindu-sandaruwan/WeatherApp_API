package com.fidenz.weather_api.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fidenz.weather_api.model.City;
import com.fidenz.weather_api.service.CityService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    public List<String> getCityCodes() {
        List<String> cityCodes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource("cities.json");
            InputStream inputStream = resource.getInputStream();

            JsonNode rootNode = objectMapper.readTree(inputStream);
            JsonNode listNode = rootNode.path("List");

            for (JsonNode cityNode : listNode) {
                cityCodes.add(cityNode.path("CityCode").asText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cityCodes;
    }
}
