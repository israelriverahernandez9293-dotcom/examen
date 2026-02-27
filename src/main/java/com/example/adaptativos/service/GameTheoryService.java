package com.example.adaptativos.service;

import com.example.adaptativos.model.DominanceResult;
import org.springframework.stereotype.Service;

@Service
public class GameTheoryService {

    public DominanceResult analyzeForAgentJ(double r1c1, double r1c2, double r2c1, double r2c2) {
        boolean col1Strict = r1c1 > r1c2 && r2c1 > r2c2;
        boolean col2Strict = r1c2 > r1c1 && r2c2 > r2c1;
        boolean col1Weak = r1c1 >= r1c2 && r2c1 >= r2c2 && (r1c1 > r1c2 || r2c1 > r2c2);
        boolean col2Weak = r1c2 >= r1c1 && r2c2 >= r2c1 && (r1c2 > r1c1 || r2c2 > r2c1);

        if (col1Strict) {
            return new DominanceResult("Estricta", "Estrategia j1 (columna 1)", explanation("j1", r1c1, r1c2, r2c1, r2c2));
        }
        if (col2Strict) {
            return new DominanceResult("Estricta", "Estrategia j2 (columna 2)", explanation("j2", r1c2, r1c1, r2c2, r2c1));
        }
        if (col1Weak) {
            return new DominanceResult("Débil", "Estrategia j1 (columna 1)", explanation("j1", r1c1, r1c2, r2c1, r2c2));
        }
        if (col2Weak) {
            return new DominanceResult("Débil", "Estrategia j2 (columna 2)", explanation("j2", r1c2, r1c1, r2c2, r2c1));
        }
        return new DominanceResult("Ninguna", "No existe estrategia dominante para j",
                "Ninguna columna supera de forma consistente a la otra comparando ambas filas.");
    }

    private String explanation(String strategy, double row1Better, double row1Other, double row2Better, double row2Other) {
        return strategy + " domina porque en fila1: " + row1Better + " vs " + row1Other +
                " y en fila2: " + row2Better + " vs " + row2Other + ".";
    }
}
