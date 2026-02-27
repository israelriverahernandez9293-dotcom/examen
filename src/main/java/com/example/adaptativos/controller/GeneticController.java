package com.example.adaptativos.controller;

import com.example.adaptativos.dto.CrossoverRequest;
import com.example.adaptativos.service.GeneticService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ga-cruza")
public class GeneticController {
    private final GeneticService geneticService;

    public GeneticController(GeneticService geneticService) { this.geneticService = geneticService; }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new CrossoverRequest());
        model.addAttribute("pseudocode", "h1 <- p1[0:pc] + p2[pc:n]\\nh2 <- p2[0:pc] + p1[pc:n]");
        return "genetic";
    }

    @PostMapping
    public String execute(@Valid @ModelAttribute("request") CrossoverRequest request, BindingResult bindingResult, Model model) {
        model.addAttribute("pseudocode", "h1 <- p1[0:pc] + p2[pc:n]\\nh2 <- p2[0:pc] + p1[pc:n]");
        if (bindingResult.hasErrors()) return "genetic";
        try {
            model.addAttribute("result", geneticService.crossover(request.getParent1(), request.getParent2(), request.getCrossoverPoint()));
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "genetic";
    }
}
