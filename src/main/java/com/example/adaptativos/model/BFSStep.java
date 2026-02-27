package com.example.adaptativos.model;

import java.util.List;

public record BFSStep(int iteration, String current, List<String> queue, List<String> visited) {
}
