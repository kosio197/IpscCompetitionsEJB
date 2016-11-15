package bg.softuni.repository;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.entity.UserModel;
import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;

@Local
public interface UsersRepository {
    void addUser(User user);

    User getUser(String username);

    void editUser(User logetUser, User user);

    UserModel editUserRole(User user);

    List<User> getRegisteredCompetitors(Competition competition);

    List<User> getAllUsers();
}
