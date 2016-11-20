package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.user.User;

@Local
public interface UserService {
    boolean usernameExists(String username);

    boolean emailExists(String email);

    void addUser(User user);

    void deleteUser(String username);

    void editUserRole(User user);

    void editProfile(User logetUser, User user);

    List<User> getAllUsers();

    User getUser(String username, String password);

    User getUser(String username);
}
