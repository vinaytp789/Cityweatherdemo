package com.example.Cityweather;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/weather")
public class CityWeatherController {

    private final WeatherSerivce weatherSerivce;

    public CityWeatherController(WeatherSerivce weatherSerivce) {
        this.weatherSerivce = weatherSerivce;
    }

    @RequestMapping("/now/{city}")
    public CurrentWeather getWeather(
                                     @PathVariable String city) {
        return this.weatherSerivce.getWeather(city);
    }


}
