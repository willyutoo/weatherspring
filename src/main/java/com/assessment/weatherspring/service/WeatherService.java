package com.assessment.weatherspring.service;

import com.assessment.weatherspring.entity.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WeatherService {
    List<Weather> findAll();

    List<Weather> findByCity(String city);

    List<Weather> findCity();

    Weather findById(Long id);

    void update(Long id, Weather user);

    void create(Weather user);

    void delete(Long id);
}
