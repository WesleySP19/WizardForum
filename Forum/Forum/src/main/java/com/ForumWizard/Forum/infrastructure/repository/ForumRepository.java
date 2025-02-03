package com.ForumWizard.Forum.infrastructure.repository;

import com.ForumWizard.Forum.models.forum.Forum;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ForumRepository {
    private final Map<UUID, Forum> forums = new HashMap<>();

    public long save(Forum forum) {
        forums.put(forum.getId(), forum);
        return 0;
    }

    public Forum findById(UUID id) {
        return forums.get(id);
    }

    public void update(Forum forum) {
        forums.put(forum.getId(), forum);
    }
}
