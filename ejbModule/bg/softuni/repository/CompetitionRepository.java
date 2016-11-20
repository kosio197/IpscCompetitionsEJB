package bg.softuni.repository;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.competition.Squad;
import bg.softuni.model.competition.Stage;

@Local
public interface CompetitionRepository {

    void addCompetition(Competition competition);

    void editCompetition(Competition competition);

    List<Competition> getAllCompetitions();

    void addCompetitor(Competition competition);

    void removeCompetitor(Competition competition);

    List<Stage> getStageByCompetition(Competition competition);

    List<Squad> getSquadsByCompetition(Competition competition);
}
