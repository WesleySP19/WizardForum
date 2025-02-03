package com.ForumWizard.Forum.models.user;

import com.ForumWizard.Forum.models.enums.UserType;

public class Admin extends User {
    public Admin(String name, String email, String password) {
        super(name, email, password, UserType.ADMIN);
    }

    public void promoteToCT(User user) {
        if (user.getUserType() == UserType.ATHLETE) {
            user.setUserType(UserType.CT);
        }
    }
}
