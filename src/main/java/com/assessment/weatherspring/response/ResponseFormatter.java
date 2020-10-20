package com.assessment.weatherspring.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ResponseFormatter extends RepresentationModel {
    //this is custom responseformatter for json structure

    private String message;
    private HttpStatus status;

    private Collection<?> result; //object result

    public ResponseFormatter(){} //constructor

    public ResponseFormatter(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public ResponseFormatter(HttpStatus status, String message, Collection<?> objects){
        this.status = status;
        this.message = message;
        this.result = objects;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Collection<?> getResult() {
        return result;
    }

    public void setResult(Collection<?> result) {
        this.result = result;
    }
}
