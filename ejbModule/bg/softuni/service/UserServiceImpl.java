package bg.softuni.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bg.softuni.model.user.User;
import bg.softuni.repository.UsersRepository;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    UsersRepository repository;

    @Override
    public void addUser(User user) {
        repository.addUser(user);
    }

    @Override
    public User deleteUser(String email) {
        return null;
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public User validateUser(String username, String password) {
        User user = repository.getUser(username);

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }

    @Override
    public void editProfile(User logetUser, User user) {
        repository.editUser(logetUser, user);
    }

    public UsersRepository getRepository() {
        return repository;
    }

    public void setRepository(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public void editUserRole(User user) {
        repository.editUserRole(user);
    }

}
