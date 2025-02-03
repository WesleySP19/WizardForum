package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.infrastructure.repository.ChatRepository;
import com.ForumWizard.Forum.models.chat.Chat;
import com.ForumWizard.Forum.models.chat.Message;
import com.ForumWizard.Forum.models.user.User;

public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat createChat(User user1, User user2) {
        Chat chat = new Chat(user1, user2);
        chatRepository.save(chat);
        return chat;
    }

    public void sendMessage(Chat chat, String content, User sender) {
        Message message = new Message(content, sender);
        chat.addMessage(message);
        chatRepository.update(chat);
    }
}
