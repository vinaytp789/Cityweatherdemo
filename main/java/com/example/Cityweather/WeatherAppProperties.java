package com.example.Cityweather;

import java.util.Arrays;
import java.util.List;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.weather")
public class WeatherAppProperties {


    private final Api api = new Api();

    private List<String> locations = Arrays.asList("UK/London", "Russia/Moscow");

    public Api getApi() {
        return this.api;
    }

    public List<String> getLocations() {
        return this.locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public static class Api {

        private String key;

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

}

