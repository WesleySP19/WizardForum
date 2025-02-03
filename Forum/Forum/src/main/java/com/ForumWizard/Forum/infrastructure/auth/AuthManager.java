package com.ForumWizard.Forum.infrastructure.auth;

import com.ForumWizard.Forum.infrastructure.repository.UserRepository;
import org.hibernate.usertype.UserType;
import com.ForumWizard.Forum.models.user.User;

public class AuthManager {
    private final UserRepository userRepository;

    public AuthManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean hasPermission(User user, UserType requiredType) {
        return user.getUserType() == requiredType;
    }
}