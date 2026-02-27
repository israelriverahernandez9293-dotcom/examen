package com.example.adaptativos.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class NeuralRequest {
    @NotBlank
    private String datasetType = "OR";
    private String customDataset = "";
    @DecimalMin("0.01")
    @DecimalMax("1.0")
    private Double learningRate = 0.2;
    @Min(1)
    private Integer epochs = 12;

    public String getDatasetType() { return datasetType; }
    public void setDatasetType(String datasetType) { this.datasetType = datasetType; }
    public String getCustomDataset() { return customDataset; }
    public void setCustomDataset(String customDataset) { this.customDataset = customDataset; }
    public Double getLearningRate() { return learningRate; }
    public void setLearningRate(Double learningRate) { this.learningRate = learningRate; }
    public Integer getEpochs() { return epochs; }
    public void setEpochs(Integer epochs) { this.epochs = epochs; }
}
