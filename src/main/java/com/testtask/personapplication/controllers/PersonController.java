package com.testtask.personapplication.controllers;

import java.util.List;
import com.testtask.personapplication.models.PersonModel;
import com.testtask.personapplication.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("search")
    public ResponseEntity<List<PersonModel>> getAllPersons(
            @RequestParam(required = false)String name,
            @RequestParam(required = false)Long age) {
        return ResponseEntity.ok().body(personService.searchPersons(name, age));
    }

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Void> createNewPerson(@Valid @RequestBody PersonModel personData) {
        personService.createNewPerson(personData);
        return ResponseEntity.noContent().build();
    }
}
