package com.ForumWizard.Forum.models.chat;

import com.ForumWizard.Forum.models.user.User;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    @Setter
    private String content;
    private User sender;
    private LocalDateTime sentAt;

    public Message(String content, User sender) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.sender = sender;
        this.sentAt = LocalDateTime.now();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}