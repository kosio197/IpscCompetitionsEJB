package bg.softuni.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.competition.Squad;
import bg.softuni.model.competition.Stage;
import bg.softuni.model.user.User;
import bg.softuni.repository.CompetitionRepository;
import bg.softuni.repository.UsersRepository;

@Stateless
public class CompetitionServiceImpl implements CompetitionService {

    @Inject
    CompetitionRepository competitionRepository;
    @Inject
    UsersRepository userRepository;

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.getAllCompetitions();
    }

    @Override
    public void addCompetition(Competition competition) {
        competitionRepository.addCompetition(competition);
    }

    public CompetitionRepository getCompetitionRepository() {
        return competitionRepository;
    }

    public void setCompetitionRepository(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public String addCompetitor(Competition competition) {
        return competitionRepository.addCompetitor(competition);
    }

    @Override
    public List<User> getCompetitors(Competition competition) {
        return userRepository.getRegisteredCompetitors(competition);
    }

    @Override
    public void removeCompetitor(Competition competition) {
        competitionRepository.removeCompetitor(competition);
    }

    @Override
    public List<Stage> getCompetitionStages(Competition competition) {
        return competitionRepository.getStageByCompetition(competition);
    }

    @Override
    public List<Squad> getCompetitionSquads(Competition competition) {
        return competitionRepository.getSquadsByCompetition(competition);
    }

    @Override
    public void editCompetition(Competition competition) {
        competitionRepository.editCompetition(competition);

    }

}
