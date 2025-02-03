package com.ForumWizard.Forum.models.forum;

import com.ForumWizard.Forum.models.user.User;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Forum {
    private UUID id;
    @Setter
    private String title;
    @Setter
    private String content;
    private User author;
    private LocalDateTime createdAt;
    private List<Comment> comments;

    public Forum(String title, String content, User author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
