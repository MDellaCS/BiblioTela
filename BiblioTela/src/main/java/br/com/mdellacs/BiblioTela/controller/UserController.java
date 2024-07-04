package br.com.mdellacs.BiblioTela.controller;

import br.com.mdellacs.BiblioTela.model.User;
import br.com.mdellacs.BiblioTela.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Teste User";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user.getUsername(), user.getPassword());
        return "User registered successfully: " + newUser.getUsername() + ", " + newUser.getPassword();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        boolean authenticatedUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (authenticatedUser == true) {
            return "";
        } else {
            return "ERRO";
        }
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
