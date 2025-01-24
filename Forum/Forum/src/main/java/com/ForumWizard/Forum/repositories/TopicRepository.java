package com.ForumWizard.Forum.repositories;

import com.ForumWizard.Forum.database.DatabaseConnection;
import com.ForumWizard.Forum.interfaces.CrudRepository;
import com.ForumWizard.Forum.models.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRepository implements CrudRepository<Topic, Integer> {

    @Override
    public void create(Topic topic) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO topics (title, content, user_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, topic.getTitle());
            statement.setString(2, topic.getContent());
            statement.setInt(3, topic.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Topic read(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM topics WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Topic topic = new Topic();
                topic.setId(resultSet.getInt("id"));
                topic.setTitle(resultSet.getString("title"));
                topic.setContent(resultSet.getString("content"));
                topic.setUserId(resultSet.getInt("user_id"));
                return topic;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Topic topic) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE topics SET title = ?, content = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, topic.getTitle());
            statement.setString(2, topic.getContent());
            statement.setInt(3, topic.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM topics WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}