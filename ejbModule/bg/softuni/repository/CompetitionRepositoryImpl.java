package bg.softuni.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.entity.CompetitionModel;
import bg.softuni.entity.CurencyModel;
import bg.softuni.entity.DisciplineModel;
import bg.softuni.entity.RegisteredUserModel;
import bg.softuni.entity.UserModel;
import bg.softuni.model.competition.Competition;
import bg.softuni.model.enumeration.Category;
import bg.softuni.model.enumeration.Discipline;
import bg.softuni.model.enumeration.HandgunDevision;
import bg.softuni.model.enumeration.PaymentStatus;
import bg.softuni.model.enumeration.PowerFactor;
import bg.softuni.model.enumeration.ResultStatus;
import bg.softuni.model.enumeration.RiffleDevision;
import bg.softuni.model.enumeration.Role;
import bg.softuni.model.enumeration.ShotgunDevision;
import bg.softuni.model.user.User;

@Singleton
public class CompetitionRepositoryImpl implements CompetitionRepository {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private HttpServletRequest request;

    @Override
    public void addCompetition(Competition competition) {
        CompetitionModel competitionModel = competitionModelToEntitiy(competition);
        em.persist(competitionModel);
    }

    @Override
    public void editCompetition(Competition competition) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Competition> getAllCompetitions() {
        String query = "select model from CompetitionModel model";
        @SuppressWarnings("unchecked")
        List<CompetitionModel> competitionModels = em.createQuery(query).getResultList();

        List<Competition> competitions = new ArrayList<>();
        for (CompetitionModel competitionModel : competitionModels) {
            competitions.add(CompetitionEntityToModel(competitionModel));
        }
        return competitions;
    }

    @Override
    public String addCompetitor(Competition competition) {
        CompetitionModel cm = getCurrentCompetition(competition);
        UserModel um = getCurrentLogetUser();
        RegisteredUserModel rum = new RegisteredUserModel(cm, um, PaymentStatus.NO.name(), ResultStatus.PROCESS.name());
        em.persist(rum);
        return "/page/competitions?faces-redirect=true";
    }

    private Competition CompetitionEntityToModel(CompetitionModel competitionModel) {
        UserModel um = competitionModel.getCreatedBy();
        User user = new User(um.getUsername(), um.getPassword(), um.getFirstName(), um.getMidleName(), um.getLastName(),
                um.getAlias(), um.getClubModel().getName(), um.getEmail(), um.getCountryModel().getName(),
                um.getTelephone(), Category.valueOf(um.getCategoryModel().getName()),
                HandgunDevision.valueOf(um.getHandgun().getName()),
                PowerFactor.valueOf(um.getHandgun().getPowerfactor().getName()),
                RiffleDevision.valueOf(um.getRifle().getName()),
                PowerFactor.valueOf(um.getRifle().getPowerfactor().getName()),
                ShotgunDevision.valueOf(um.getShotgun().getName()), Role.valueOf(um.getRole().getName()));

        return new Competition(competitionModel.getName(), competitionModel.getAddress(),
                competitionModel.getCurency().getName(), competitionModel.getDescription(), user,
                competitionModel.getMainMathDate(), competitionModel.getPreMathDate(),
                competitionModel.getRegistryDeadLineDate(), competitionModel.getPaymentDeadLineDate(),
                competitionModel.getLevel(), competitionModel.getEntryFee(),
                Discipline.valueOf(competitionModel.getDiscipline().getName()), competitionModel.getMinRounds(),
                competitionModel.getStageCount());

    }

    private CompetitionModel competitionModelToEntitiy(Competition competition) {

        CurencyModel curencyModel = em.createNamedQuery("currencyByName", CurencyModel.class)
                .setParameter("currencyName", competition.getFeeCurrency()).getSingleResult();

        UserModel userModel = getCurrentLogetUser();

        DisciplineModel disciplineModel = em.createNamedQuery("disciplineByName", DisciplineModel.class)
                .setParameter("disciplineName", competition.getDiscipline().name()).getSingleResult();

        return new CompetitionModel(competition.getName(), competition.getAddress(), competition.getPrematchDate(),
                competition.getMatchDate(), competition.getRegistrationDeadline(), competition.getPaymentDeadline(),
                competition.getFee(), curencyModel, competition.getLevel(), competition.getDescription(), userModel,
                disciplineModel, competition.getMinRound(), competition.getStageCount());
    }

    private UserModel getCurrentLogetUser() {

        User currentLogetUser = (User) request.getSession().getAttribute("LOGGED_USER");
        String query = "select model from UserModel model where model.username = :un";
        Query q = em.createQuery(query);
        q.setParameter("un", currentLogetUser.getUsername());

        return (UserModel) q.getSingleResult();
    }

    private CompetitionModel getCurrentCompetition(Competition competition) {
        String query = "select c from CompetitionModel c where c.name = :cName and c.mainMathDate = :cMainMatch";
        Query q = em.createQuery(query);
        q.setParameter("cName", competition.getName());
        q.setParameter("cMainMatch", competition.getMatchDate());

        return (CompetitionModel) q.getSingleResult();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}
