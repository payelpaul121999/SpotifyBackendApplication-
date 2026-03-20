package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.model.User;
import com.palpa.spotifybackend.model.Role;
import com.palpa.spotifybackend.model.SubscriptionType;
import com.palpa.spotifybackend.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ===============================
    // ADMIN: Get all users
    // ===============================
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ===============================
    // Get user by ID
    // ===============================
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ===============================
    // Get current logged-in user (JWT)
    // ===============================
    public User getCurrentUser() {

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ===============================
    // Upgrade current user to PAID
    // ===============================
    public User upgradeToPaid() {

        User user = getCurrentUser();

        user.setSubscriptionType(SubscriptionType.PAID);

        return userRepository.save(user);
    }

    // ===============================
    // ADMIN: Create Admin User
    // ===============================
    public User createAdmin(User user) {

        user.setRole(Role.ADMIN);
        user.setSubscriptionType(SubscriptionType.PAID);
        user.setListeningTimeToday(0);

        return userRepository.save(user);
    }

    // ===============================
    // Reset daily listening time (optional)
    // ===============================
    public User resetListeningTime(Long userId){

        User user = getUserById(userId);

        user.setListeningTimeToday(0);

        return userRepository.save(user);
    }

    // ===============================
    // Delete user (ADMIN)
    // ===============================
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
} 
