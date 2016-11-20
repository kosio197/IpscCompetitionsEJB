package bg.softuni.model.competition;

import java.io.Serializable;
import java.util.Date;

import bg.softuni.model.enumeration.Discipline;
import bg.softuni.model.user.User;

public class Competition implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String address;
    private String feeCurrency;
    private String description;
    private User createdBy;
    private Date matchDate;
    private Date prematchDate;
    private Date registrationDeadline;
    private Date paymentDeadline;
    private int level;
    private double entryFee;
    private Discipline discipline;
    private Integer minRound;
    private Integer stageCount;
    private byte[] stages;
    private byte[] results;
    private byte[] squads;

    public Competition() {

    }

    public Competition(String name, String address, String feeCurrency, String description, User createdBy,
            Date matchDate, Date prematchDate, Date registrationDeadline, Date paymentDeadline, int level,
            double entryFee, Discipline discipline, Integer minRound, Integer stageCount) {
        super();
        this.name = name;
        this.address = address;
        this.feeCurrency = feeCurrency;
        this.description = description;
        this.createdBy = createdBy;
        this.matchDate = matchDate;
        this.prematchDate = prematchDate;
        this.registrationDeadline = registrationDeadline;
        this.paymentDeadline = paymentDeadline;
        this.level = level;
        this.entryFee = entryFee;
        this.discipline = discipline;
        this.minRound = minRound;
        this.stageCount = stageCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public double getFee() {
        return entryFee;
    }

    public void setFee(double fee) {
        this.entryFee = fee;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public Date getPrematchDate() {
        return prematchDate;
    }

    public void setPrematchDate(Date prematchDate) {
        this.prematchDate = prematchDate;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public Integer getMinRound() {
        return minRound;
    }

    public void setMinRound(Integer minRound) {
        this.minRound = minRound;
    }

    public Integer getStageCount() {
        return stageCount;
    }

    public void setStageCount(Integer stageCount) {
        this.stageCount = stageCount;
    }

    public byte[] getStages() {
        return stages;
    }

    public void setStages(byte[] stages) {
        this.stages = stages;
    }

    public byte[] getResults() {
        return results;
    }

    public void setResults(byte[] results) {
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getSquads() {
        return squads;
    }

    public void setSquads(byte[] squads) {
        this.squads = squads;
    }

    public String getDisciplineAsString() {
        return discipline.toString();
    }

}
