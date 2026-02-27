package com.example.adaptativos.service;

import com.example.adaptativos.dto.AutoTuneRequest;
import com.example.adaptativos.model.AutoTuneStep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoTuneService {

    public List<AutoTuneStep> simulate(AutoTuneRequest request) {
        List<AutoTuneStep> steps = new ArrayList<>();
        double output = request.getInitialValue();
        double parameter = request.getProportionalGain();
        Random random = new Random(42);

        for (int i = 1; i <= request.getIterations(); i++) {
            double noise = (random.nextDouble() * 2 - 1) * request.getNoiseAmplitude();
            double measured = output + noise;
            double error = request.getSetpoint() - measured;
            parameter = Math.max(0.01, parameter + 0.01 * error);
            output = output + parameter * error;
            steps.add(new AutoTuneStep(i, measured, error, parameter, output));
        }
        return steps;
    }
}
