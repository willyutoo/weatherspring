package com.assessment.weatherspring.service.implementation;

import com.assessment.weatherspring.entity.Weather;
import com.assessment.weatherspring.repository.WeatherRepository;
import com.assessment.weatherspring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public List<Weather> findByCity(String city) {
        return weatherRepository.findByCity(city);
    }

    @Override
    public List<Weather> findCity() {
        return weatherRepository.findCity();
    }

    @Override
    public Weather findById(Long id) {
        return weatherRepository.getOne(id);
    }

    @Override
    public void update(Long id, Weather user) {
        weatherRepository.save(user);
    }

    @Override
    public void create(Weather newUser) {
        weatherRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        weatherRepository.deleteById(id);
    }
}
