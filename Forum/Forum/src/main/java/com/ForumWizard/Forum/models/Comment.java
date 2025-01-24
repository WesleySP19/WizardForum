package com.ForumWizard.Forum.models;

public class Comment {
    private int id;
    private String content;
    private int authorId;
    private int topicId;

    public Comment(int id, String content, int authorId, int topicId) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.topicId = topicId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public int getTopicId() { return topicId; }
    public void setTopicId(int topicId) { this.topicId = topicId; }
}