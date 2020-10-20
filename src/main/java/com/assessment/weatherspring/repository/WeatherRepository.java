package com.assessment.weatherspring.repository;

import com.assessment.weatherspring.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query("SELECT w FROM Weather w WHERE w.city= ?1 ORDER BY w.id desc") //Query Annotation
    List<Weather> findByCity(String city);

    @Query("SELECT w FROM Weather w GROUP BY w.city ORDER BY w.id desc")
    List<Weather> findCity();

    //additional custom method for JPA
}
