package bg.softuni.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import competition.bg.softuni.model.enumeration.PaymentStatus;
import competition.bg.softuni.model.enumeration.ResultStatus;

@Entity
@Table(name = "registered_users")
public class RegisteredUserModel {

    private Integer id;
    private CompetitionModel competition;
    private UserModel user;
    private PaymentStatus paymentStatus;
    private ResultStatus resultStatus;

    public RegisteredUserModel() {

    }

    public RegisteredUserModel(CompetitionModel competition, UserModel user, PaymentStatus paymentStatus,
            ResultStatus resultStatus) {
        super();
        this.competition = competition;
        this.user = user;
        this.paymentStatus = paymentStatus;
        this.resultStatus = resultStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

}
