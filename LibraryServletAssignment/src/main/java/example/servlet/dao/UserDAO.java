package example.servlet.dao;

import java.util.List;

import example.servlet.entity.User;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();
}