package com.example.adaptativos.controller;

import com.example.adaptativos.dto.NeuralRequest;
import com.example.adaptativos.service.NeuralService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/redes-neuronales")
public class NeuralController {
    private final NeuralService neuralService;

    public NeuralController(NeuralService neuralService) { this.neuralService = neuralService; }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new NeuralRequest());
        return "neural";
    }

    @PostMapping
    public String train(@Valid @ModelAttribute("request") NeuralRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "neural";
        try {
            model.addAttribute("result", neuralService.train(request.getDatasetType(), request.getCustomDataset(), request.getLearningRate(), request.getEpochs()));
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "neural";
    }
}
