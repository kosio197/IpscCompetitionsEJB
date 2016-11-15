package bg.softuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registered_users")
public class RegisteredUserModel {

    private Long id;
    private CompetitionModel competition;
    private UserModel user;
    private String paymentStatus;
    private String resultStatus;

    public RegisteredUserModel() {

    }

    public RegisteredUserModel(CompetitionModel competition, UserModel user, String paymentStatus,
            String resultStatus) {
        super();
        this.competition = competition;
        this.user = user;
        this.paymentStatus = paymentStatus;
        this.resultStatus = resultStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    @ManyToOne
    public CompetitionModel getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionModel competition) {
        this.competition = competition;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Column(name = "payment_status", nullable = false)
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Column(name = "result_status", nullable = false)
    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

}
