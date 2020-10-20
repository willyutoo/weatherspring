package com.assessment.weatherspring.entity;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class Weather extends RepresentationModel<Weather> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="city")
    private String city;

    @Column(name="date")
    private String date;

    @Column(name="degree")
    private String degree;

    @Column(name="weather")
    private String weather;

    @Column(name="wind")
    private double wind;

    @Column(name="humidity")
    private double humidity;

    @Column(name="pressure")
    private double pressure;

    public Weather(){}

    public Weather(long id, String city, String date, String degree, String weather, double wind, double humidity, double pressure) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.degree = degree;
        this.weather = weather;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public Weather(String city, String date, String degree, String weather, double wind, double humidity, double pressure) {
        this.city = city;
        this.date = date;
        this.degree = degree;
        this.weather = weather;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
