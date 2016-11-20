package bg.softuni.model.user;

import java.io.Serializable;

import bg.softuni.model.enumeration.Category;
import bg.softuni.model.enumeration.HandgunDevision;
import bg.softuni.model.enumeration.PowerFactor;
import bg.softuni.model.enumeration.RifleDevision;
import bg.softuni.model.enumeration.Role;
import bg.softuni.model.enumeration.ShotgunDevision;

public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String alias;
    private String shootingClub;
    private String email;
    private String country;
    private String telephone;

    private Category category;

    private HandgunDevision defaultHandgunDevision;
    private PowerFactor defaultHandgunPowerFactor;

    private RifleDevision defaultRifleDevision;
    private PowerFactor defaultRiflePowerFactor;

    private ShotgunDevision defaultShotgunDevision;

    private Role role;

    public User() {
        defaultHandgunDevision = HandgunDevision.PRD;
        defaultShotgunDevision = ShotgunDevision.STD;
        defaultRifleDevision = RifleDevision.MAO;

        defaultHandgunPowerFactor = PowerFactor.MIN;
        defaultRiflePowerFactor = PowerFactor.MIN;

        category = Category.REGULAR;

        country = "Bulgaria";

        role = Role.USER;
    }

    public User(String username, String password, String firstName, String middleName, String lastName, String alias,
            String shootingClub, String email, String country, String telephone, Category category,
            HandgunDevision defaultHandgunDevision, PowerFactor defaultHandgunPowerFactor,
            RifleDevision defaultRifleDevision, PowerFactor defaultRiflePowerFactor,
            ShotgunDevision defaultShotgunDevision, Role role) {
        super();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.alias = alias;
        this.shootingClub = shootingClub;
        this.email = email;
        this.country = country;
        this.telephone = telephone;
        this.category = category;
        this.defaultHandgunDevision = defaultHandgunDevision;
        this.defaultHandgunPowerFactor = defaultHandgunPowerFactor;
        this.defaultRifleDevision = defaultRifleDevision;
        this.defaultRiflePowerFactor = defaultRiflePowerFactor;
        this.defaultShotgunDevision = defaultShotgunDevision;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShotgunDevision getDefaultShotgunDevision() {
        return defaultShotgunDevision;
    }

    public void setDefaultShotgunDevision(ShotgunDevision defaultShotgunDevision) {
        this.defaultShotgunDevision = defaultShotgunDevision;
    }

    public RifleDevision getDefaultRifleDevision() {
        return defaultRifleDevision;
    }

    public void setDefaultRifleDevision(RifleDevision defaultRifleDevision) {
        this.defaultRifleDevision = defaultRifleDevision;
    }

    public PowerFactor getDefaultHandgunPowerFactor() {
        return defaultHandgunPowerFactor;
    }

    public void setDefaultHandgunPowerFactor(PowerFactor defaultHandgunPowerFactor) {
        this.defaultHandgunPowerFactor = defaultHandgunPowerFactor;
    }

    public PowerFactor getDefaultRiflePowerFactor() {
        return defaultRiflePowerFactor;
    }

    public void setDefaultRiflePowerFactor(PowerFactor defaultRiflePowerFactor) {
        this.defaultRiflePowerFactor = defaultRiflePowerFactor;
    }

    public HandgunDevision getDefaultHandgunDevision() {
        return defaultHandgunDevision;
    }

    public void setDefaultHandgunDevision(HandgunDevision defaultHandgunDevision) {
        this.defaultHandgunDevision = defaultHandgunDevision;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getShootingClub() {
        return shootingClub;
    }

    public void setShootingClub(String shootingClub) {
        this.shootingClub = shootingClub;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDefaultHandgunDevisionAsString() {
        return defaultHandgunDevision.toString();
    }

    public String getDefaultShotgunDevisionAsString() {
        return defaultShotgunDevision.toString();
    }

    public String getDefaultRifleDevisionAsString() {
        return defaultRifleDevision.toString();
    }

    public String getDefaulHandgunPowerFactorAsString() {
        return defaultHandgunPowerFactor.toString();
    }

    public String getDefaulRiflePowerFactorAsString() {
        return defaultRiflePowerFactor.toString();
    }

    public String getRoleAsString() {
        return role.toString();
    }

    public void setRoleAsString(String role) {
        setRole(Role.valueOf(role));
    }

    public String getCategoryAsString() {
        return category.toString();
    }
}
