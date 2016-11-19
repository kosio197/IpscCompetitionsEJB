package bg.softuni.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.resteasy.util.Hex;

import bg.softuni.model.user.User;
import bg.softuni.repository.UsersRepository;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    UsersRepository repository;

    @Override
    public void addUser(User user) {
        user.setPassword(getEncodePassword(user.getPassword()));
        repository.addUser(user);
    }

    @Override
    public void deleteUser(String username) {
        repository.removeUser(username);
    }

    @Override
    public User getUser(String username, String password) {
        User user = repository.getUser(username);
        if (user == null || !user.getPassword().equals(getEncodePassword(password))) {
            return null;
        }
        return user;
    }

    @Override
    public void editProfile(User logetUser, User user) {
        if (!user.getPassword().equals("")) {
            user.setPassword(getEncodePassword(user.getPassword()));
        }
        repository.editUser(logetUser, user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public void editUserRole(User user) {
        repository.editUserRole(user);
    }

    public UsersRepository getRepository() {
        return repository;
    }

    public void setRepository(UsersRepository repository) {
        this.repository = repository;
    }

    private String getEncodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return new String(Hex.encodeHex(hash));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No encoding algorythm found", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("No encoding support", e);
        }
    }

}
