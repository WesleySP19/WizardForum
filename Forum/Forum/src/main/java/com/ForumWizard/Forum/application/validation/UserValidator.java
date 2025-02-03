package com.ForumWizard.Forum.application.validation;

import com.ForumWizard.Forum.models.exceptions.ValidationException;
import com.ForumWizard.Forum.models.user.User;

public class UserValidator {
    public static void validateUserDTO(User userDTO) throws ValidationException {
        if (!userDTO.getEmail().matches("[^@]+@[^@]+\\.[^@]+")) {
            throw new ValidationException("Email inválido.");
        }
        if (userDTO.getPassword().length() < 8) {
            throw new ValidationException("Senha deve ter no mínimo 8 caracteres.");
        }
    }
}
