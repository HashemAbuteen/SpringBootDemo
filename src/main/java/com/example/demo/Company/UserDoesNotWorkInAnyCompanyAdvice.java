package com.example.demo.Company;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UserDoesNotWorkInAnyCompanyAdvice {

    @ResponseBody
    @ExceptionHandler(UserDoesNotWorkInAnyCompanyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String companyNotFoundHandler(UserDoesNotWorkInAnyCompanyException ex) {
        return ex.getMessage();
    }
}