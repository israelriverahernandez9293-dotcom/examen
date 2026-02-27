package com.example.adaptativos.controller;

import com.example.adaptativos.dto.GraphRequest;
import com.example.adaptativos.service.BFSService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bfs")
public class GraphController {
    private final BFSService bfsService;

    public GraphController(BFSService bfsService) { this.bfsService = bfsService; }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("request", new GraphRequest());
        return "bfs";
    }

    @PostMapping
    public String execute(@Valid @ModelAttribute("request") GraphRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "bfs";
        try {
            model.addAttribute("result", bfsService.execute(request.getNodes(), request.getEdges(), request.getStartNode().trim()));
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "bfs";
    }
}
