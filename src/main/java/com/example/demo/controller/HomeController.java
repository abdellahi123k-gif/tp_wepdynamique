package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.ProductEntity;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
     private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<ProductEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name , @RequestParam Double price, @RequestParam String description) {

        userRepository.save(new ProductEntity(null, name, price, description));

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {

        ProductEntity user = userRepository.findById(id).orElse(null);

        model.addAttribute("user", user);

        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(ProductEntity user) {

        userRepository.save(user);

        return "redirect:/";
    }



}

