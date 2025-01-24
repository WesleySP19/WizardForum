package com.ForumWizard.Forum.models;

public class NormalUser extends User {
    private boolean isActive;

    public NormalUser(int id, String name, String email, String password, boolean isActive) {
        super(id, name, email, password);
        this.isActive = isActive;
    }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
