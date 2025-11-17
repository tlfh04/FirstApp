package com.example.firstapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/hello")
    public String hello(Model model) {
        String name = "yongmin";
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("username", "yongmin");
        model.addAttribute("age", "18");
        model.addAttribute("city","seoul");
        return "user";
    }
    @GetMapping("/fruits")
    public String fruits(Model model) {
        List<String> fruitList = new ArrayList<>();
        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("cherry");
        fruitList.add("lemon");
        fruitList.add("kiwi");
        model.addAttribute("fruits", fruitList);
        return "fruits";
    }
    @GetMapping("/grade")
    public String grade(Model model) {
        int score = 80;
        model.addAttribute("score", score);
        return "grade";
    }
}
