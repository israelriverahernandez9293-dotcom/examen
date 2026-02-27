package com.example.adaptativos.controller;

import com.example.adaptativos.dto.AutoTuneRequest;
import com.example.adaptativos.service.AutoTuneService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auto-ajuste")
public class AutoTuneController {
    private final AutoTuneService autoTuneService;

    public AutoTuneController(AutoTuneService autoTuneService) { this.autoTuneService = autoTuneService; }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new AutoTuneRequest());
        return "auto-tune";
    }

    @PostMapping
    public String simulate(@Valid @ModelAttribute("request") AutoTuneRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "auto-tune";
        model.addAttribute("steps", autoTuneService.simulate(request));
        return "auto-tune";
    }
}
