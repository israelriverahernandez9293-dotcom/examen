package com.example.adaptativos.dto;

import jakarta.validation.constraints.NotBlank;

public class QuizRequest {
    @NotBlank
    private String q1 = "fractal";
    @NotBlank
    private String q2 = "sensibilidad";

    public String getQ1() { return q1; }
    public void setQ1(String q1) { this.q1 = q1; }
    public String getQ2() { return q2; }
    public void setQ2(String q2) { this.q2 = q2; }
}
