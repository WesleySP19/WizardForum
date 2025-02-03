package com.ForumWizard.Forum.repositories;

import com.ForumWizard.Forum.database.DatabaseConnection;
import com.ForumWizard.Forum.interfaces.CrudRepository;
import com.ForumWizard.Forum.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Integer> {

    @Override
    public void create(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User() {
                };
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}