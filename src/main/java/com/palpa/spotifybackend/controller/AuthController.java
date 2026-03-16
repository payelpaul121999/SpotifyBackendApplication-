package com.palpa.spotifybackend.controller;


import com.palpa.spotifybackend.model.User;
import com.palpa.spotifybackend.model.Role;
import com.palpa.spotifybackend.model.SubscriptionType;
import com.palpa.spotifybackend.repository.UserRepository;
import com.palpa.spotifybackend.config.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.USER);
        user.setSubscriptionType(SubscriptionType.FREE);
        // ADD THIS LINE:
        user.setListeningTimeToday(0); 
        return userRepository.save(user);
    }
   

    // LOGIN
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return Map.of("token", token);
    }
    
    public User upgradeToPaid(Long userId){

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setSubscriptionType(SubscriptionType.PAID);

    return userRepository.save(user);
    }

  
}
