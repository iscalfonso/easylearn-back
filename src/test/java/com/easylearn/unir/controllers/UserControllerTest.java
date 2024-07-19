package com.easylearn.unir.controllers;

import com.easylearn.unir.dao.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
class UserControllerTest {

    private final static String BASE_PATH = "http://localhost/users";
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    void save() throws Exception {
        User user = new User(null, "Julio", "1111111115", "12345", 1L);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(user))
        ).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void findById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + "/2")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void edit() throws Exception {
        User user = new User(19L, "Julito", "1111111114", "12345", 2L);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(BASE_PATH)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(user))
        ).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void delete() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_PATH + "/21")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}