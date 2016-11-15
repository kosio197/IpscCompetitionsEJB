package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.user.User;

@Local
public interface UserService {
    public void addUser(User user);

    public User deleteUser(String email);

    public User getUser(String email);

    public User validateUser(String username, String password);

    public void editProfile(User logetUser, User user);

    public List<User> getAllUsers();

    public void editUserRole(User user);
}
