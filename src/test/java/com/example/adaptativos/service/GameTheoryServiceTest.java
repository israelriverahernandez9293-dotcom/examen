package com.example.adaptativos.service;

import com.example.adaptativos.model.DominanceResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTheoryServiceTest {
    private final GameTheoryService service = new GameTheoryService();

    @Test
    void detectsStrictDominanceForColumn1() {
        DominanceResult result = service.analyzeForAgentJ(4, 1, 3, 2);
        assertEquals("Estricta", result.type());
        assertEquals("Estrategia j1 (columna 1)", result.strategy());
    }
}
