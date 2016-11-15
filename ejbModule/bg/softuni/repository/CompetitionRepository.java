package bg.softuni.repository;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.competition.Competition;

@Local
public interface CompetitionRepository {

    void addCompetition(Competition competition);

    void editCompetition(Competition competition);

    List<Competition> getAllCompetitions();

    String addCompetitor(Competition competition);
}
