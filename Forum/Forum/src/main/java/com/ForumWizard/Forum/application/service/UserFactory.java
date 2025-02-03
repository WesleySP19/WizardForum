package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.models.user.Admin;
import com.ForumWizard.Forum.models.user.Athlete;
import com.ForumWizard.Forum.models.user.CT;
import com.ForumWizard.Forum.models.user.User;

public class UserFactory {
    public static User createUser(User userDTO) {
        switch (userDTO.getUserType()) {
            case ADMIN:
                return new Admin(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
            case CT:
                return new CT(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
            case ATHLETE:
                return new Athlete(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(),
                        userDTO.getPlayerName(), userDTO.getJerseyNumber());
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido.");
        }
    }
}
