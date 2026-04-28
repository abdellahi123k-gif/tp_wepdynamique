package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/Patien")
public class PateinController {
    @GetMapping("/p")
    public String sayHello() {
        return "say hello";
    }
}

