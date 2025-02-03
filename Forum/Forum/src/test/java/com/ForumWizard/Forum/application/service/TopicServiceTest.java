package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.models.forum.Topic;
import com.ForumWizard.Forum.repositories.TopicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TopicServiceTest {
    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private TopicService topicService;

    @Test
    public void testCreateTopic() {
        Topic topic = new Topic("Bem-vindo", "Conteúdo", 1L);
        when(topicRepository.save(topic)).thenReturn(topic);

        Topic savedTopic = topicService.createTopic(topic);
        assertEquals("Bem-vindo", savedTopic.getTitle());
        verify(topicRepository, times(1)).save(topic);
    }
}
