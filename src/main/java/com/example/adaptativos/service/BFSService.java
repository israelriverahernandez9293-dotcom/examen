package com.example.adaptativos.service;

import com.example.adaptativos.model.BFSResult;
import com.example.adaptativos.model.BFSStep;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BFSService {

    public BFSResult execute(String nodesInput, String edgesInput, String startNode) {
        List<String> nodes = Arrays.stream(nodesInput.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .distinct()
                .collect(Collectors.toList());
        if (!nodes.contains(startNode)) {
            throw new IllegalArgumentException("El nodo origen debe existir en la lista de nodos");
        }

        Map<String, List<String>> graph = new HashMap<>();
        nodes.forEach(n -> graph.put(n, new ArrayList<>()));

        for (String edge : edgesInput.split(",")) {
            String[] parts = edge.trim().split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Formato de aristas inválido. Usa A-B, B-C...");
            }
            String a = parts[0].trim();
            String b = parts[1].trim();
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                throw new IllegalArgumentException("Todas las aristas deben usar nodos declarados");
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        graph.values().forEach(Collections::sort);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        Map<String, Integer> levels = new LinkedHashMap<>();
        List<String> order = new ArrayList<>();
        List<BFSStep> steps = new ArrayList<>();

        queue.add(startNode);
        visited.add(startNode);
        levels.put(startNode, 0);

        int iteration = 1;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    levels.put(neighbor, levels.get(current) + 1);
                }
            }
            steps.add(new BFSStep(iteration++, current, new ArrayList<>(queue), new ArrayList<>(visited)));
        }

        return new BFSResult(order, levels, steps);
    }
}
