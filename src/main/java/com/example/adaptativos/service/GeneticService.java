package com.example.adaptativos.service;

import com.example.adaptativos.model.CrossoverResult;
import org.springframework.stereotype.Service;

@Service
public class GeneticService {

    public CrossoverResult crossover(String p1, String p2, int pc) {
        if (p1 == null || p2 == null || p1.isBlank() || p2.isBlank()) {
            throw new IllegalArgumentException("Los padres no pueden estar vacíos");
        }
        if (!p1.matches("[01]+") || !p2.matches("[01]+")) {
            throw new IllegalArgumentException("Los cromosomas deben ser binarios (0 y 1)");
        }
        if (p1.length() != p2.length()) {
            throw new IllegalArgumentException("p1 y p2 deben tener el mismo tamaño");
        }
        if (pc <= 0 || pc >= p1.length()) {
            throw new IllegalArgumentException("El punto de cruza debe estar entre 1 y n-1");
        }

        String h1 = p1.substring(0, pc) + p2.substring(pc);
        String h2 = p2.substring(0, pc) + p1.substring(pc);
        String explanation = "Se toma prefijo de p1 y sufijo de p2 para h1; prefijo de p2 y sufijo de p1 para h2.";
        return new CrossoverResult(h1, h2, explanation);
    }
}
