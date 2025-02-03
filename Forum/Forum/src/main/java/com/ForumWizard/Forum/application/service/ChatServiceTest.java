package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.infrastructure.repository.ChatRepository;
import com.ForumWizard.Forum.models.chat.Chat;
import com.ForumWizard.Forum.models.user.User;

class ChatServiceTest {
    private ChatService chatService;
    private ChatRepository chatRepository;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        chatRepository = new ChatRepository();
        chatService = new ChatService(chatRepository);
        user1 = new User("John Doe", "john@example.com", "password123", UserType.ATHLETE);
        user2 = new User("Jane Doe", "jane@example.com", "password123", UserType.ATHLETE);
    }

    @Test
    void testCreateChat() {
        Chat chat = chatService.createChat(user1, user2);
        assertNotNull(chat);
        assertEquals(user1, chat.getUser1());
    }

    private void assertEquals(User user1, User user11) {
    }

    private void assertNotNull(Chat chat) {
    }

    @Test
    void testSendMessage() {
        Chat chat = chatService.createChat(user1, user2);
        chatService.sendMessage(chat, "Olá!", user1);
        assertEquals(1, chat.getMessages().size());
    }
}
