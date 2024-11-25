package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String home() {
        return "Bem-vindo à API de Assinaturas!";
    }
}