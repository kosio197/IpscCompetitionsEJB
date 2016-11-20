package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.competition.Squad;
import bg.softuni.model.competition.Stage;
import bg.softuni.model.user.User;

@Local
public interface CompetitionService {

    List<Competition> getAllCompetitions();

    void addCompetition(Competition competition);

    void addCompetitor(Competition competition);

    List<User> getCompetitors(Competition competition);

    void removeCompetitor(Competition competition);

    List<Stage> getCompetitionStages(Competition competition);

    List<Squad> getCompetitionSquads(Competition competition);

    void editCompetition(Competition competition);

}
