package com.testtask.personapplication.mappers;

import com.testtask.personapplication.entites.Person;
import com.testtask.personapplication.models.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "name", source = "personName")
    @Mapping(target = "age", source = "personAge")
    PersonModel toPersonDto(Person personData);

    @Mapping(target = "personName", source = "name")
    @Mapping(target = "personAge", source = "age")
    @Mapping(target = "id", ignore = true)
    Person toPersonEntity(PersonModel personModel);
}
