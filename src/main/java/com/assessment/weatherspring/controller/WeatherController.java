package com.assessment.weatherspring.controller;

import com.assessment.weatherspring.entity.Weather;
import com.assessment.weatherspring.response.ResponseFormatter;
import com.assessment.weatherspring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/weather") //base url for api usability
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseFormatter fetchAll() { /*List<Weather>*/
        try {
            List<Weather> weatherList = weatherService.findAll();
            for (Weather weather : weatherList) {
                Link selfLink = WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel();
                weather.add(selfLink);
            }
            ResponseFormatter result = new ResponseFormatter();
            result.add(WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel());
            result.setStatus(HttpStatus.FOUND);
            result.setMessage("Success");
            result.setResult(weatherList);
            return result;
        } catch (NullPointerException ex) {
            return new ResponseFormatter(HttpStatus.NOT_FOUND,
                    "Weather data not found");
        } catch (Exception ex) {
            return new ResponseFormatter(HttpStatus.FORBIDDEN,
                    ex.getMessage());
        }
    }

    @RequestMapping(value="/city/{city}", method = RequestMethod.GET, produces = "application/json")
    public ResponseFormatter fetchByCity(@PathVariable("city") String city) { /*List<Weather>*/
        try {
            List<Weather> weatherList = weatherService.findByCity(city);
            for (Weather weather : weatherList) {
                Link selfLink = WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel();
                weather.add(selfLink);
            }
            ResponseFormatter result = new ResponseFormatter();
            result.add(WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel());
            result.setStatus(HttpStatus.FOUND);
            result.setMessage("Success");
            result.setResult(weatherList);
            return result;
        } catch (NullPointerException ex) {
            return new ResponseFormatter(HttpStatus.NOT_FOUND,
                    "Weather data not found");
        } catch (Exception ex) {
            return new ResponseFormatter(HttpStatus.FORBIDDEN,
                    ex.getMessage());
        }
    }

    @RequestMapping(value="/city", method = RequestMethod.GET, produces = "application/json")
    public ResponseFormatter fetchCity() {
        try {
            List<Weather> weatherList = weatherService.findCity();
            for (Weather weather : weatherList) {
                Link selfLink = WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel();
                weather.add(selfLink);
            }
            ResponseFormatter result = new ResponseFormatter();
            result.add(WebMvcLinkBuilder.linkTo(WeatherController.class).withSelfRel());
            result.setStatus(HttpStatus.FOUND);
            result.setMessage("Success");
            result.setResult(weatherList);
            return result;
        } catch (NullPointerException ex) {
            return new ResponseFormatter(HttpStatus.NOT_FOUND,
                    "City data not found");
        } catch (Exception ex) {
            return new ResponseFormatter(HttpStatus.FORBIDDEN,
                    ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseFormatter create (@RequestBody @Validated Weather weather) {
        try {
            System.out.println(weather.getCity());
            Weather newWeather = new Weather();
            newWeather.setCity(weather.getCity());
            newWeather.setDate(weather.getDate());
            newWeather.setDegree(weather.getDegree());
            newWeather.setWeather(weather.getWeather());
            newWeather.setWind(weather.getWind());
            newWeather.setHumidity(weather.getHumidity());
            newWeather.setPressure(weather.getPressure());
            weatherService.create(newWeather);
            return new ResponseFormatter(HttpStatus.CREATED, "Weather created Successfully");
        } catch (Exception ex) {
            return new ResponseFormatter(HttpStatus.BAD_REQUEST, ex.toString());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseFormatter delete (@PathVariable("id") long id) {
        try {
            weatherService.delete(id);
            return new ResponseFormatter(HttpStatus.ACCEPTED, "Weather removed successfully");
        } catch (NullPointerException ex) {
            return new ResponseFormatter(HttpStatus.NOT_FOUND,
                    "Weather data not found");
        } catch (Exception ex) {
            return new ResponseFormatter(HttpStatus.BAD_REQUEST, ex.toString());
        }
    }
}
