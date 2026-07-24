package com.shuaiyin.studyplanner.controller;

import com.shuaiyin.studyplanner.model.User;
import com.shuaiyin.studyplanner.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return Map.of("message", "Username already exists");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            return Map.of("message", "Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return Map.of("message", "User registered successfully");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest){

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElse(null);

        if(user == null){
            return Map.of("message", "Invalid username or password");
        }

        boolean passwordMatches = passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword()
        );

        if(!passwordMatches){
            return Map.of("message", "Invalid username or password");
        }

        return Map.of("message", "Login successful");
    }
}
