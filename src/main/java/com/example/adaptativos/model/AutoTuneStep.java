package com.example.adaptativos.model;

public record AutoTuneStep(int iteration, double measured, double error, double adjustedParameter, double output) {
}
