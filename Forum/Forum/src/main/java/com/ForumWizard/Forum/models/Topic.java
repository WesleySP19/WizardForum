package com.ForumWizard.Forum.models;

public class Topic {
    private int id;
    private String title;
    private String content;
    private int userId; // ID do usuário associado ao tópico

    // Construtor padrão
    public Topic() {}

    // Construtor com argumentos
    public Topic(int id, String title, String content, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() { // Apenas uma definição do getter
        return userId;
    }

    public void setUserId(int userId) { // Apenas uma definição do setter
        this.userId = userId;
    }
}
