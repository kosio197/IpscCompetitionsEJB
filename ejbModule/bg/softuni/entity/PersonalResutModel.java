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
@Table(name = "personal_resuts")
public class PersonalResutModel {

    private Integer id;
    private UserModel user;
    private StageModel stage;
    private Integer alpha;
    private Integer charly;
    private Integer delta;
    private Integer miss;
    private Integer penalityTarget;
    private Integer procedure;
    private Double stageTame;

    public PersonalResutModel() {

    }

    public PersonalResutModel(UserModel user, StageModel stage, Integer alpha, Integer charly, Integer delta,
            Integer miss, Integer penalityTarget, Integer procedure, Double stageTame) {
        super();
        this.user = user;
        this.stage = stage;
        this.alpha = alpha;
        this.charly = charly;
        this.delta = delta;
        this.miss = miss;
        this.penalityTarget = penalityTarget;
        this.procedure = procedure;
        this.stageTame = stageTame;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    @ManyToOne
    public StageModel getStage() {
        return stage;
    }

    public void setStage(StageModel stage) {
        this.stage = stage;
    }

    @Column(name = "A")
    public Integer getAlpha() {
        return alpha;
    }

    public void setAlpha(Integer alpha) {
        this.alpha = alpha;
    }

    @Column(name = "C")
    public Integer getCharly() {
        return charly;
    }

    public void setCharly(Integer charly) {
        this.charly = charly;
    }

    @Column(name = "D")
    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    @Column(name = "miss")
    public Integer getMiss() {
        return miss;
    }

    public void setMiss(Integer miss) {
        this.miss = miss;
    }

    @Column(name = "P_T")
    public Integer getPenalityTarget() {
        return penalityTarget;
    }

    public void setPenalityTarget(Integer penalityTarget) {
        this.penalityTarget = penalityTarget;
    }

    @Column(name = "proc")
    public Integer getProcedure() {
        return procedure;
    }

    public void setProcedure(Integer procedure) {
        this.procedure = procedure;
    }

    @Column(name = "time", nullable = false)
    public Double getStageTame() {
        return stageTame;
    }

    public void setStageTame(Double stageTame) {
        this.stageTame = stageTame;
    }

}
