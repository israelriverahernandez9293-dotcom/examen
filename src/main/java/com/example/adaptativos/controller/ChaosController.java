package com.example.adaptativos.controller;

import com.example.adaptativos.dto.QuizRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/caos-quiz")
public class ChaosController {

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new QuizRequest());
        return "chaos";
    }

    @PostMapping
    public String evaluate(@Valid @ModelAttribute("request") QuizRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "chaos";
        List<String> feedback = new ArrayList<>();
        feedback.add("fractal".equalsIgnoreCase(request.getQ1()) ? "Q1 correcta: Fractal es una estructura auto-similar." : "Q1 incorrecta: la respuesta correcta era Fractal.");
        feedback.add("sensibilidad".equalsIgnoreCase(request.getQ2()) ? "Q2 correcta: pequeñas variaciones iniciales cambian drásticamente la evolución." : "Q2 incorrecta: la opción correcta era sensibilidad a condiciones iniciales.");
        model.addAttribute("feedback", feedback);
        return "chaos";
    }
}
