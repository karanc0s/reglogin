package com.karan.reglogin.config;

import com.karan.reglogin.payload.response.AppErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionResolver {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppErrorResponse> handleException(Exception e , HttpServletRequest request) {
        System.out.println("Handler");
        return ResponseEntity.status(400).body( AppErrorResponse.builder().message(e.getMessage()).build() );
    }

}
