package com.testtask.personapplication.services;

import java.util.List;
import java.util.stream.Collectors;
import com.testtask.personapplication.mappers.PersonMapper;
import com.testtask.personapplication.models.PersonModel;
import com.testtask.personapplication.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    /**
     * This method for to search persons
     * @param name
     * @param age
     * @return
     */
    public List<PersonModel> searchPersons(String name, Long age) {
        return personRepository.searchPersonData(name, age)
                .stream().map(personMapper::toPersonDto).collect(Collectors.toList());
    }

    /**
     *
     * @param personData requested value to store
     */
    public void createNewPerson(PersonModel personData) {
        personRepository.save(personMapper.toPersonEntity(personData));
    }
}
