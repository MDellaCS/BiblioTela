package br.com.example.teste.controller;

import br.com.example.teste.model.User;
import br.com.example.teste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Teste User";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user.getName(), user.getEmail());
        return "User registered successfully: " + newUser.getName() + ", " + newUser.getEmail();
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
