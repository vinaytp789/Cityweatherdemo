package com.example.Cityweather;


import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CurrentWeather implements Serializable {


    public CurrentWeather(double temperature) {
        this.temperature = temperature;
    }

    private double temperature;

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);

    }



}
