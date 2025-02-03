package com.ForumWizard.Forum.infrastructure.repository;

import com.ForumWizard.Forum.models.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepository {
    private Map<Long, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(UUID id) {
        return users.get(id);
    }

    public User findByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void update(User user) {
        users.put(user.getId(), user);
    }
}

