package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(name = "userByUsername", query = "SELECT c FROM UserModel c WHERE c.username = :username"),
        @NamedQuery(name = "userByEmail", query = "SELECT c FROM UserModel c WHERE c.email = :email"),
})
@Entity
@Table(name = "users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String midleName;
    private String lastName;
    private String username;
    private String alias;
    private String password;
    private String email;
    private String telephone;
    private RoleModel role;
    private ClubModel clubModel;
    private CountryModel countryModel;
    private CategoryModel categoryModel;
    private HandgunDivisionModel handgun;
    private ShotgunDivisionModel shotgun;
    private RifleDivisionModel rifle;

    public UserModel() {

    }

    public UserModel(String firstName, String midleName, String lastName, String username, String alias,
            String password, String email, String telephone, RoleModel role, ClubModel clubModel,
            CountryModel countryModel, CategoryModel categoryModel, HandgunDivisionModel handgun,
            ShotgunDivisionModel shotgun, RifleDivisionModel rifle) {
        super();
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.username = username;
        this.alias = alias;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
        this.clubModel = clubModel;
        this.countryModel = countryModel;
        this.categoryModel = categoryModel;
        this.handgun = handgun;
        this.shotgun = shotgun;
        this.rifle = rifle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "midle_name")
    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    @JoinColumn(name = "club_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    public ClubModel getClubModel() {
        return clubModel;
    }

    public void setClubModel(ClubModel clubModel) {
        this.clubModel = clubModel;
    }

    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    public CountryModel getCountryModel() {
        return countryModel;
    }

    public void setCountryModel(CountryModel countryModel) {
        this.countryModel = countryModel;
    }

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    @JoinColumn(name = "handgun_division_id", referencedColumnName = "id")
    @ManyToOne
    public HandgunDivisionModel getHandgun() {
        return handgun;
    }

    public void setHandgun(HandgunDivisionModel handgun) {
        this.handgun = handgun;
    }

    @JoinColumn(name = "shoting_division_id", referencedColumnName = "id")
    @ManyToOne
    public ShotgunDivisionModel getShotgun() {
        return shotgun;
    }

    public void setShotgun(ShotgunDivisionModel shotgun) {
        this.shotgun = shotgun;
    }

    @JoinColumn(name = "rifle_division_id", referencedColumnName = "id")
    @ManyToOne
    public RifleDivisionModel getRifle() {
        return rifle;
    }

    public void setRifle(RifleDivisionModel rifle) {
        this.rifle = rifle;
    }

}
