package com.testtask.personapplication.repositories;

import java.util.List;
import com.testtask.personapplication.entites.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from person where (:name is null or person_name Like %:name%) " +
            "and (:age is null or person_age = :age) ", nativeQuery = true)
    List<Person> searchPersonData(@Param("name")String name, @Param("age")Long age);
}
