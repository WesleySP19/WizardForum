package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.infrastructure.repository.ForumRepository;
import com.ForumWizard.Forum.models.forum.Comment;
import com.ForumWizard.Forum.models.forum.Forum;
import com.ForumWizard.Forum.models.user.User;

import java.util.UUID;

public class ForumService {
    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Forum createTopic(String title, String content, User author) {
        Forum forum = new Forum(title, content, author);
        forumRepository.save(forum);
        return forum;
    }

    public void addComment(Forum forum, String content, User author) {
        Comment comment = new Comment(content, author);
        forum.addComment(comment);
        forumRepository.update(forum);
    }

    public Forum findById(UUID topicId) {
        return null;
    }
}
