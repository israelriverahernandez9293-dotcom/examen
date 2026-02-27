package com.example.adaptativos.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AutoTuneRequest {
    @NotNull
    private Double setpoint = 50.0;
    @NotNull
    private Double initialValue = 20.0;
    @DecimalMin("0.0")
    @DecimalMax("20.0")
    private Double noiseAmplitude = 1.0;
    @Min(1)
    private Integer iterations = 12;
    @DecimalMin("0.01")
    @DecimalMax("2.0")
    private Double proportionalGain = 0.25;

    public Double getSetpoint() { return setpoint; }
    public void setSetpoint(Double setpoint) { this.setpoint = setpoint; }
    public Double getInitialValue() { return initialValue; }
    public void setInitialValue(Double initialValue) { this.initialValue = initialValue; }
    public Double getNoiseAmplitude() { return noiseAmplitude; }
    public void setNoiseAmplitude(Double noiseAmplitude) { this.noiseAmplitude = noiseAmplitude; }
    public Integer getIterations() { return iterations; }
    public void setIterations(Integer iterations) { this.iterations = iterations; }
    public Double getProportionalGain() { return proportionalGain; }
    public void setProportionalGain(Double proportionalGain) { this.proportionalGain = proportionalGain; }
}
