package com.example.adaptativos.service;

import com.example.adaptativos.model.BFSResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BFSServiceTest {
    private final BFSService service = new BFSService();

    @Test
    void bfsReturnsExpectedOrderAndLevels() {
        BFSResult result = service.execute("A,B,C,D", "A-B, A-C, B-D", "A");
        assertEquals("A", result.visitOrder().get(0));
        assertEquals(0, result.levels().get("A"));
        assertEquals(1, result.levels().get("B"));
    }
}
