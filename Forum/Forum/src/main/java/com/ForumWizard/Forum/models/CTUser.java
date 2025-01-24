package com.ForumWizard.Forum.models;

public class CTUser extends User {
    private String role;


    public CTUser(int id, String name, String email, String password, String role) {
        super(id, name, email, password);
        this.role = role;
    }


    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
