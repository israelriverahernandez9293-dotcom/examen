package com.example.adaptativos.service;

import com.example.adaptativos.model.CrossoverResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneticServiceTest {
    private final GeneticService service = new GeneticService();

    @Test
    void crossoverWorks() {
        CrossoverResult result = service.crossover("1100", "0011", 2);
        assertEquals("1111", result.child1());
        assertEquals("0000", result.child2());
    }

    @Test
    void crossoverRejectsInvalidPoint() {
        assertThrows(IllegalArgumentException.class, () -> service.crossover("1100", "0011", 0));
    }
}
