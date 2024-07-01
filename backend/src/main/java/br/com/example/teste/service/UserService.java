package br.com.example.teste.service;

import br.com.example.teste.model.User;
import br.com.example.teste.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
