package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;

@Local
public interface CompetitionService {

    List<Competition> getAllCompetitions();

    void addCompetition(Competition competition);

    String addCompetitor(Competition competition);

    List<User> getCompetitors(Competition competition);

}
