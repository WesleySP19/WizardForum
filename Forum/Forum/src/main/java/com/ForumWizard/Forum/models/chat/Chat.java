package com.ForumWizard.Forum.models.chat;

import com.ForumWizard.Forum.models.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chat {
    private UUID id;
    private User user1;
    private User user2;
    private List<Message> messages;

    public Chat(User user1, User user2) {
        this.id = UUID.randomUUID();
        this.user1 = user1;
        this.user2 = user2;
        this.messages = new ArrayList<>();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
