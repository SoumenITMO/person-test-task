package com.testtask.personapplication.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_age")
    private Long personAge;

    @Column(name = "person_name")
    private String personName;
}
