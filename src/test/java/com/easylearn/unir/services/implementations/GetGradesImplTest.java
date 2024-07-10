package com.easylearn.unir.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GetGradesImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void deadline() {
        long startTime = new Date().getTime();
        long endTime = new Date().getTime() + 1000 * 60 * 60 * 24;
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        assertTrue(diffDays > 0);
    }

    @Test
    void grades() {
        double a =8;
        double b =7;
             double total = (a+b)/2;
        assertEquals(total, 7.5);
    }


}