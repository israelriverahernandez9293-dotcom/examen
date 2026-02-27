package com.example.adaptativos.service;

import com.example.adaptativos.model.NeuralEpoch;
import com.example.adaptativos.model.NeuralResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NeuralService {

    public NeuralResult train(String datasetType, String customDataset, double learningRate, int epochs) {
        List<double[]> dataset = resolveDataset(datasetType, customDataset);
        double w1 = 0.1;
        double w2 = -0.2;
        double bias = 0.0;
        double iW1 = w1, iW2 = w2, iB = bias;
        List<NeuralEpoch> log = new ArrayList<>();

        for (int epoch = 1; epoch <= epochs; epoch++) {
            double totalError = 0;
            for (double[] sample : dataset) {
                double x1 = sample[0], x2 = sample[1], y = sample[2];
                double net = x1 * w1 + x2 * w2 + bias;
                double pred = net >= 0 ? 1 : 0;
                double error = y - pred;
                totalError += Math.abs(error);
                w1 += learningRate * error * x1;
                w2 += learningRate * error * x2;
                bias += learningRate * error;
            }
            log.add(new NeuralEpoch(epoch, w1, w2, bias, totalError));
        }
        return new NeuralResult(iW1, iW2, iB, log, w1, w2, bias);
    }

    private List<double[]> resolveDataset(String type, String customDataset) {
        if ("CUSTOM".equalsIgnoreCase(type) && customDataset != null && !customDataset.isBlank()) {
            List<double[]> data = new ArrayList<>();
            String[] rows = customDataset.split("\\n");
            for (String row : rows) {
                String[] values = row.trim().split(",");
                if (values.length != 3) {
                    throw new IllegalArgumentException("Dataset manual inválido. Usa formato x1,x2,y por línea.");
                }
                data.add(new double[]{Double.parseDouble(values[0].trim()), Double.parseDouble(values[1].trim()), Double.parseDouble(values[2].trim())});
            }
            return data;
        }
        if ("AND".equalsIgnoreCase(type)) {
            return List.of(new double[]{0, 0, 0}, new double[]{0, 1, 0}, new double[]{1, 0, 0}, new double[]{1, 1, 1});
        }
        return List.of(new double[]{0, 0, 0}, new double[]{0, 1, 1}, new double[]{1, 0, 1}, new double[]{1, 1, 1});
    }
}
