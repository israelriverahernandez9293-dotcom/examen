package com.example.adaptativos.model;

import java.util.List;
import java.util.Map;

public record BFSResult(List<String> visitOrder, Map<String, Integer> levels, List<BFSStep> steps) {
}
