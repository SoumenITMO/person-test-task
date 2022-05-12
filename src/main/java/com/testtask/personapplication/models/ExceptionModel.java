package com.testtask.personapplication.models;

import com.testtask.personapplication.exceptions.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionModel {

    private int code;
    private String message;

    public ExceptionModel(AppException e) {

        setCode(e.getCode());
        setMessage(e.getMessage());
    }
}
