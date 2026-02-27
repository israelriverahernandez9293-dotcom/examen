package com.example.adaptativos.model;

import java.util.List;

public record NeuralResult(double initialW1, double initialW2, double initialBias, List<NeuralEpoch> epochs,
                           double finalW1, double finalW2, double finalBias) {
}
