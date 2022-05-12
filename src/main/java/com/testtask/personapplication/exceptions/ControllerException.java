package com.testtask.personapplication.exceptions;

import com.testtask.personapplication.models.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerException {

    @ResponseBody
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ExceptionModel> handleSystemException(AppException appException) {

        return wrapIntoResponseEntity(appException, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionModel> handleAllExceptions(Exception exception) {
        return wrapIntoResponseEntity(new ExceptionModel(ExceptionCodes.UNMAPPED_EXCEPTION_CODE, exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionModel> wrapIntoResponseEntity (AppException ex, HttpStatus status){

        return ResponseEntity
                .status(status)
                .body(new ExceptionModel(ex));
    }

    private ResponseEntity<ExceptionModel> wrapIntoResponseEntity (ExceptionModel exDto, HttpStatus status){

        return ResponseEntity
                .status(status)
                .body(exDto);
    }
}