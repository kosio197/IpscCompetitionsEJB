package bg.softuni.repository;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;

@Local
public interface UsersRepository {
    void addUser(User user);

    void editUser(User logetUser, User user);

    void removeUser(String username);

    void editUserRole(User user);

    User getUser(String username);

    List<User> getRegisteredCompetitors(Competition competition);

    List<User> getAllUsers();

}
