package com.easylearn.unir.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {
    private final static String BASE_PATH = "http://localhost/posts";
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }
    @Test
    void save() {
    }

    @Test
    void getByTeacher() {
    }

    @Test
    void getByStudent() {
    }

    @Test
    void getById() {
    }

    @Test
    void edit() {
    }

    @Test
    void disable() {
    }

    @Test
    void delete() {
    }
}