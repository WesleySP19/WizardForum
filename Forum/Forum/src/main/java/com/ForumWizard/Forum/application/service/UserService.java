package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.application.validation.UserValidator;
import com.ForumWizard.Forum.infrastructure.repository.UserRepository;
import com.ForumWizard.Forum.models.enums.UserType;
import com.ForumWizard.Forum.models.exceptions.ValidationException;
import com.ForumWizard.Forum.models.user.Admin;
import com.ForumWizard.Forum.models.user.User;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User userDTO) throws ValidationException {
        UserValidator.validateUserDTO(userDTO);
        User user = UserFactory.createUser(userDTO);
        userRepository.save(user);
        return user;
    }

    public void promoteToCT(User user, Admin admin) {
        if (admin.getUserType() == UserType.ADMIN) {
            admin.promoteToCT(user);
            userRepository.update(user);
        }
    }

    public User getCurrentUser() {
        return null;
    }
}
