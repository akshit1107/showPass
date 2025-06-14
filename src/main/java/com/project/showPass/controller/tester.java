package com.project.showPass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class tester {
    @GetMapping("/tester")
    public String test() {
        return "Hello from tester!";
    }
}
