package com.ForumWizard.Forum.repositories;

import com.ForumWizard.Forum.database.DatabaseConnection;
import com.ForumWizard.Forum.interfaces.CrudRepository;
import com.ForumWizard.Forum.models.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository implements CrudRepository<Message, Integer> {

    @Override
    public void create(Message message) {
        String sql = "INSERT INTO messages (content, media_path, sender_id, receiver_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, message.getContent());
            statement.setString(2, message.getMediaPath());
            statement.setInt(3, message.getSenderId());
            statement.setInt(4, message.getReceiverId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message read(Integer id) {
        String sql = "SELECT * FROM messages WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToMessage(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Message message) {
        String sql = "UPDATE messages SET content = ?, media_path = ?, sender_id = ?, receiver_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, message.getContent());
            statement.setString(2, message.getMediaPath());
            statement.setInt(3, message.getSenderId());
            statement.setInt(4, message.getReceiverId());
            statement.setInt(5, message.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM messages WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve all messages between two users.
     *
     * @param senderId   ID of the sender.
     * @param receiverId ID of the receiver.
     * @return List of messages exchanged between the users.
     */
    public List<Message> getMessagesBetweenUsers(int senderId, int receiverId) {
        String sql = "SELECT * FROM messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY id";
        List<Message> messages = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, senderId);
            statement.setInt(2, receiverId);
            statement.setInt(3, receiverId);
            statement.setInt(4, senderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                messages.add(mapResultSetToMessage(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    /**
     * Map a ResultSet row to a Message object.
     *
     * @param resultSet ResultSet containing the row data.
     * @return Message object.
     * @throws SQLException if there is an error mapping the data.
     */
    private Message mapResultSetToMessage(ResultSet resultSet) throws SQLException {
        Message message = new Message();
        message.setId(resultSet.getInt("id"));
        message.setContent(resultSet.getString("content"));
        message.setMediaPath(resultSet.getString("media_path"));
        message.setSenderId(resultSet.getInt("sender_id"));
        message.setReceiverId(resultSet.getInt("receiver_id"));
        return message;
    }
}
