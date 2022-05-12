package com.testtask.personapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PersonModel {


    @NotNull(message = "Name can not be left null")
    private String name;

    @NotNull(message = "Age can not be left null")
    private Long age;
}
