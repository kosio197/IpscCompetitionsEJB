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
@Table(name = "stages")
public class StageModel {

    private Integer id;
    private Integer stageNumber;
    private CompetitionModel competition;
    private Integer minRound;
    private Integer maxPoints;
    private String description;
    private byte[] stageImage;

    public StageModel() {

    }

    public StageModel(Integer stageNumber, CompetitionModel competition, Integer minRound, Integer maxPoints,
            String description, byte[] stageImage) {
        super();
        this.stageNumber = stageNumber;
        this.competition = competition;
        this.minRound = minRound;
        this.maxPoints = maxPoints;
        this.description = description;
        this.stageImage = stageImage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "number", nullable = false)
    public Integer getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    @ManyToOne
    public CompetitionModel getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionModel competition) {
        this.competition = competition;
    }

    @Column(name = "min_rounds", nullable = false)
    public Integer getMinRound() {
        return minRound;
    }

    public void setMinRound(Integer minRound) {
        this.minRound = minRound;
    }

    @Column(name = "max_points", nullable = false)
    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "stage_img", nullable = false)
    public byte[] getStageImage() {
        return stageImage;
    }

    public void setStageImage(byte[] stageImage) {
        this.stageImage = stageImage;
    }

}
