package com.example.Cityweather;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherSerivce {
    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    private final String apiKey;

    public WeatherSerivce(RestTemplateBuilder restTemplateBuilder,
                          WeatherAppProperties properties,
                          ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = properties.getApi().getKey();
        this.objectMapper = objectMapper;
    }


    public CurrentWeather getWeather( String city) {
        URI url = new UriTemplate(WEATHER_URL).expand(city, this.apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convert(response);

    }


    private CurrentWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new CurrentWeather(root.path("main").path("temp").asDouble());

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}

