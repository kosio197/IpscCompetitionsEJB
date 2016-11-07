package bg.softuni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "competitions")
public class CompetitionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date preMathDate;
    private Date mainMathDate;
    private Date registryDeadLineDate;
    private Date paymentDeadLineDate;
    private Double entryFee;
    private CurencyModel curency;
    private Integer level;
    private String description;
    private UserModel createdBy;

    public CompetitionModel() {

    }

    public CompetitionModel(String name, Date preMathDate, Date mainMathDate, Date registryDeadLineDate,
            Date paymentDeadLineDate, Double entryFee, CurencyModel curency, Integer level, String description,
            UserModel createdBy) {
        super();
        this.name = name;
        this.preMathDate = preMathDate;
        this.mainMathDate = mainMathDate;
        this.registryDeadLineDate = registryDeadLineDate;
        this.paymentDeadLineDate = paymentDeadLineDate;
        this.entryFee = entryFee;
        this.curency = curency;
        this.level = level;
        this.description = description;
        this.setCreatedBy(createdBy);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date_pre_match")
    @Temporal(TemporalType.DATE)
    public Date getPreMathDate() {
        return preMathDate;
    }

    public void setPreMathDate(Date preMathDate) {
        this.preMathDate = preMathDate;
    }

    @Column(name = "date_main_match")
    @Temporal(TemporalType.DATE)
    public Date getMainMathDate() {
        return mainMathDate;
    }

    public void setMainMathDate(Date mainMathDate) {
        this.mainMathDate = mainMathDate;
    }

    @Column(name = "date_registry_deadline")
    @Temporal(TemporalType.DATE)
    public Date getRegistryDeadLineDate() {
        return registryDeadLineDate;
    }

    public void setRegistryDeadLineDate(Date registryDeadLineDate) {
        this.registryDeadLineDate = registryDeadLineDate;
    }

    @Column(name = "date_payment_deadline")
    @Temporal(TemporalType.DATE)
    public Date getPaymentDeadLineDate() {
        return paymentDeadLineDate;
    }

    public void setPaymentDeadLineDate(Date paymentDeadLineDate) {
        this.paymentDeadLineDate = paymentDeadLineDate;
    }

    @Column(name = "entry_fee", nullable = false)
    public Double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Double entryFee) {
        this.entryFee = entryFee;
    }

    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @ManyToOne
    public CurencyModel getCurency() {
        return curency;
    }

    public void setCurency(CurencyModel curency) {
        this.curency = curency;
    }

    @Column(name = "match_level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

}
