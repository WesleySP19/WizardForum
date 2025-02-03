package com.ForumWizard.Forum.models.forum;

import com.ForumWizard.Forum.models.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private UUID id;
    private String content;
    private User author;
    private LocalDateTime createdAt;

    public Comment(String content, User author) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Object Comment(String content, User author) {
        return null;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
