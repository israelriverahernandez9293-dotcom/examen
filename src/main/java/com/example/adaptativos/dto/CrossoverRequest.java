package com.example.adaptativos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrossoverRequest {
    @NotBlank
    private String parent1 = "110011";
    @NotBlank
    private String parent2 = "001111";
    @NotNull
    @Min(1)
    private Integer crossoverPoint = 3;

    public String getParent1() { return parent1; }
    public void setParent1(String parent1) { this.parent1 = parent1; }
    public String getParent2() { return parent2; }
    public void setParent2(String parent2) { this.parent2 = parent2; }
    public Integer getCrossoverPoint() { return crossoverPoint; }
    public void setCrossoverPoint(Integer crossoverPoint) { this.crossoverPoint = crossoverPoint; }
}
