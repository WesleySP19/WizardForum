package com.ForumWizard.Forum.infrastructure.repository;

import com.ForumWizard.Forum.models.chat.Chat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatRepository {
    private final Map<UUID, Chat> chats = new HashMap<>();

    public void save(Chat chat) {
        chats.put(chat.getId(), chat);
    }

    public Chat findById(UUID id) {
        return chats.get(id);
    }

    public void update(Chat chat) {
        chats.put(chat.getId(), chat);
    }
}