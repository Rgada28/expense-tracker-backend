package com.rgada28.expensetracker.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record ErrorResponse(HttpStatus status, List<String> errors,LocalDateTime timeStamp) {

//    ErrorResponse(HttpStatus status, String message, String error,LocalDateTime timeStamp){
//        super();
//        this.status=status;
//        this.timeStamp=timeStamp;
//        this.message=message;
//        this.errors= Arrays.asList(error);
//    }
}
