package com.example.adaptativos.dto;

import jakarta.validation.constraints.NotNull;

public class MultiAgentRequest {
    @NotNull
    private Double r1c1 = 3.0;
    @NotNull
    private Double r1c2 = 1.0;
    @NotNull
    private Double r2c1 = 4.0;
    @NotNull
    private Double r2c2 = 2.0;

    public Double getR1c1() { return r1c1; }
    public void setR1c1(Double r1c1) { this.r1c1 = r1c1; }
    public Double getR1c2() { return r1c2; }
    public void setR1c2(Double r1c2) { this.r1c2 = r1c2; }
    public Double getR2c1() { return r2c1; }
    public void setR2c1(Double r2c1) { this.r2c1 = r2c1; }
    public Double getR2c2() { return r2c2; }
    public void setR2c2(Double r2c2) { this.r2c2 = r2c2; }
}
