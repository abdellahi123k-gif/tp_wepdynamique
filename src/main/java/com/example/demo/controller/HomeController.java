package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.UserEntity;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
     private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<UserEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name) {

        userRepository.save(new UserEntity(null, name));

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {

        UserEntity user = userRepository.findById(id).orElse(null);

        model.addAttribute("user", user);

        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(UserEntity user) {

        userRepository.save(user);

        return "redirect:/";
    }



}

