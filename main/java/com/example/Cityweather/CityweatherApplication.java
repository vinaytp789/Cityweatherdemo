package com.example.Cityweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
public class CityweatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityweatherApplication.class, args);
	}
}
