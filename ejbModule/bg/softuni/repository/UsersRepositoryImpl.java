package bg.softuni.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bg.softuni.entity.CategoryModel;
import bg.softuni.entity.ClubModel;
import bg.softuni.entity.CountryModel;
import bg.softuni.entity.HandgunDivisionModel;
import bg.softuni.entity.RifleDivisionModel;
import bg.softuni.entity.RoleModel;
import bg.softuni.entity.ShotgunDivisionModel;
import bg.softuni.entity.UserModel;
import bg.softuni.model.competition.Competition;
import bg.softuni.model.enumeration.Category;
import bg.softuni.model.enumeration.HandgunDevision;
import bg.softuni.model.enumeration.PowerFactor;
import bg.softuni.model.enumeration.RiffleDevision;
import bg.softuni.model.enumeration.Role;
import bg.softuni.model.enumeration.ShotgunDevision;
import bg.softuni.model.user.User;

@Singleton
public class UsersRepositoryImpl implements UsersRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        UserModel userModel = userModelToEntity(user);
        em.persist(userModel);
    }

    @Override
    public User getUser(String username) {
        return userEntityToModel(getUserModel(username));
    }

    @Override
    public List<User> getAllUsers() {
        Query q = em.createQuery("select u from UserModel u");
        @SuppressWarnings("unchecked")
        List<UserModel> models = q.getResultList();
        List<User> users = new ArrayList<>();
        for (UserModel userModel : models) {
            users.add(userEntityToModel(userModel));
        }
        return users;
    }

    @Override
    public void removeUser(String username) {
        UserModel um = getUserModel(username);
        em.remove(um);
        em.flush();
    }

    @Override
    public void editUser(User LogedUser, User user) {
        UserModel um = getUserModel(LogedUser.getUsername());
        um.setAlias(user.getAlias());
        um.getCategoryModel().setName(user.getCategory().name());
        um.getClubModel().setName(user.getShootingClub());
        um.getCountryModel().setName(user.getCountry());
        um.setEmail(user.getEmail());
        um.setFirstName(user.getFirstName());
        um.getHandgun().setName(user.getDefaultHandgunDevision().name());
        um.getHandgun().getPowerfactor().setName(user.getDefaultHandgunPowerFactor().name());
        um.setLastName(user.getLastName());
        um.setMidleName(user.getMiddleName());
        if (user.getPassword() == null || !user.getPassword().equals("")) {
            um.setPassword(user.getPassword());
        }
        um.getRifle().setName(user.getDefaultRiffleDevision().name());
        um.getRifle().getPowerfactor().setName(user.getDefaultRifflePowerFactor().name());
        um.getShotgun().setName(user.getDefaultShotgunDevision().name());
        um.setTelephone(user.getTelephone());
        um.setUsername(user.getUsername());
        em.merge(um);
        em.flush();
    }

    @Override
    public void editUserRole(User user) {
        UserModel um = getUserModel(user.getUsername());
        Query q = em.createNamedQuery("roleByName", RoleModel.class).setParameter("roleName", user.getRole().name());
        RoleModel rm = (RoleModel) q.getSingleResult();

        um.setRole(rm);
        em.merge(um);
        em.flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getRegisteredCompetitors(Competition competition) {
        String query = "select u from UserModel as u, RegisteredUserModel as ru, CompetitionModel as c "
                + "where c.name = :cName and c.mainMathDate = :cMainMatch and ru.user.id = u.id and ru.competition.id = c.id";
        Query q = em.createQuery(query);
        q.setParameter("cName", competition.getName());
        q.setParameter("cMainMatch", competition.getMatchDate());

        List<UserModel> userModels = q.getResultList();
        List<User> users = new ArrayList<>();
        for (UserModel userModel : userModels) {
            users.add(userEntityToModel(userModel));
        }
        return users;
    }

    private User userEntityToModel(UserModel um) {
        User user = new User(um.getUsername(), um.getPassword(), um.getFirstName(), um.getMidleName(), um.getLastName(),
                um.getAlias(), um.getClubModel().getName(), um.getEmail(), um.getCountryModel().getName(),
                um.getTelephone(), Category.valueOf(um.getCategoryModel().getName()),
                HandgunDevision.valueOf(um.getHandgun().getName()),
                PowerFactor.valueOf(um.getHandgun().getPowerfactor().getName()),
                RiffleDevision.valueOf(um.getRifle().getName()),
                PowerFactor.valueOf(um.getRifle().getPowerfactor().getName()),
                ShotgunDevision.valueOf(um.getShotgun().getName()), Role.valueOf(um.getRole().getName()));

        return user;
    }

    private UserModel userModelToEntity(User user) {

        RoleModel roleModel = em.createNamedQuery("roleByName", RoleModel.class)
                .setParameter("roleName", user.getRole().toString()).getSingleResult();

        CategoryModel categoryModel = em.createNamedQuery("categoryByName", CategoryModel.class)
                .setParameter("categoryName", user.getCategory().toString()).getSingleResult();

        ClubModel clubModel = null;
        try {

            clubModel = em.createNamedQuery("clubByName", ClubModel.class)
                    .setParameter("clubName", user.getShootingClub()).getSingleResult();
        } catch (NoResultException nre) {
            clubModel = new ClubModel(user.getShootingClub());
        }

        CountryModel countryModel = em.createNamedQuery("countryByName", CountryModel.class)
                .setParameter("countryName", user.getCountry()).getSingleResult();

        HandgunDivisionModel hdm = em.createNamedQuery("hdmByName", HandgunDivisionModel.class)
                .setParameter("hdmName", user.getDefaultHandgunDevision().toString())
                .setParameter("pfName", user.getDefaultHandgunPowerFactor().toString()).getSingleResult();

        ShotgunDivisionModel sdm = null;
        if (user.getDefaultShotgunDevision() != null) {

            sdm = em.createNamedQuery("sdmByName", ShotgunDivisionModel.class)
                    .setParameter("sdmName", user.getDefaultShotgunDevision().toString()).getSingleResult();
        }

        RifleDivisionModel rdm = null;

        if (user.getDefaultRiffleDevision() != null) {
            rdm = em.createNamedQuery("rdmByName", RifleDivisionModel.class)
                    .setParameter("rdmName", user.getDefaultRiffleDevision().toString())
                    .setParameter("pfName", user.getDefaultRifflePowerFactor().toString()).getSingleResult();
        }

        return new UserModel(user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getUsername(),
                user.getAlias(), user.getPassword(), user.getEmail(), user.getTelephone(), roleModel, clubModel,
                countryModel, categoryModel, hdm, sdm, rdm);

    }

    private UserModel getUserModel(String username) {

        Query q = em.createQuery("select model from UserModel model where model.username = :um ");
        q.setParameter("um", username);

        UserModel um = null;
        try {
            um = (UserModel) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.toString());
        }
        return um;
    }

}
