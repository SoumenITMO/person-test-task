package com.testtask.personapplication.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtask.personapplication.models.PersonModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void test_to_create_a_new_person() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new PersonModel("Mark Mark", 45L))))
                .andExpect(status().isNoContent());
    }

    @Test
    void test_to_search_person_using_name() throws Exception {
        String personData = mockMvc.perform(MockMvcRequestBuilders.get("/person/search?name=Mark")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<PersonModel> persons = Arrays.asList(mapper.readValue(personData, PersonModel[].class));

        assertTrue(persons.size() >= 1);
    }
}