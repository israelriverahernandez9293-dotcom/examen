package com.example.adaptativos.controller;

import com.example.adaptativos.dto.MultiAgentRequest;
import com.example.adaptativos.service.GameTheoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/multiagente")
public class MultiAgentController {
    private final GameTheoryService gameTheoryService;

    public MultiAgentController(GameTheoryService gameTheoryService) { this.gameTheoryService = gameTheoryService; }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new MultiAgentRequest());
        return "multiagent";
    }

    @PostMapping
    public String analyze(@Valid @ModelAttribute("request") MultiAgentRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "multiagent";
        model.addAttribute("result", gameTheoryService.analyzeForAgentJ(
                request.getR1c1(), request.getR1c2(), request.getR2c1(), request.getR2c2()));
        return "multiagent";
    }
}
