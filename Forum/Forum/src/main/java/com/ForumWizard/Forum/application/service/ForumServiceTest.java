package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.infrastructure.repository.ForumRepository;
import com.ForumWizard.Forum.models.forum.Forum;
import com.ForumWizard.Forum.models.user.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ForumServiceTest {
    private ForumService forumService;
    private ForumRepository forumRepository;
    private User user;

    @BeforeEach
    void setUp() {
        forumRepository = mock(ForumRepository.class);
        forumService = new ForumService(forumRepository);
        user = new User("Wesley Souza", "wesley@example.com", "flag123!", UserType.ATHLETE);
    }

    private ForumRepository mock(Class<ForumRepository> forumRepositoryClass) {
    }

    @Test
    public void testCreateTopic() {
        Forum forum = new Forum("Título", "Conteúdo", user);
        wait(forumRepository.save(forum)).thenReturn(forum);

        Forum savedForum = forumService.createTopic("Título", "Conteúdo", user);
        assertNotNull(savedForum);
        assertEquals("Título", savedForum.getTitle());
        verify(forumRepository, times(1)).save(forum);
    }
}