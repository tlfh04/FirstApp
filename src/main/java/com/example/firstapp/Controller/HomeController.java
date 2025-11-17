package com.example.firstapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    @GetMapping("/lunch")
    public String lunch(Model model) {
        List<String> menus = Arrays.asList("김밥","라면","돈까스");

        Random random = new Random();
        String pick = menus.get(random.nextInt(menus.size()));
        model.addAttribute("menu", pick);
        return "lunch";
    }
    @GetMapping("lotto")
    public String lotto(Model model) {
        List<Integer> numbers = IntStream.range(1,46).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> lucky = numbers.subList(0,6);
        Collections.sort(lucky);
        model.addAttribute("lucky", lucky);
        return "lotto";
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);

        return "profile";
    }

    @GetMapping("/cube/{number}")
    public String cube(@PathVariable Integer number, Model model) {
        int result = number * number * number;
        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "cube";
    }

    @GetMapping("/number/{number}")
    public String number(@PathVariable Integer number, Model model) {
        String result = number % 2 == 0 ? "짝수입니다." : "홀수입니다.";
        model.addAttribute("number", number);
        model.addAttribute("result",result);
        return "number";
    }
    @GetMapping("/age/{birthday}")
    public String age(@PathVariable Integer birthday, Model model) {
        int age = Year.now().getValue() - birthday ;
        model.addAttribute("birthday", birthday);
        model.addAttribute("age", age);
        return "age";
    }

    @GetMapping("/ping")
    public String ping(Model model) {
        return "ping";
    }

    @GetMapping("/pong")
    public String pong(@RequestParam String title,@RequestParam String content, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "pong";
    }
}
