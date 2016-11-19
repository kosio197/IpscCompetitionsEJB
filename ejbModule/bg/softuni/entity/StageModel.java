package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stages")
public class StageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private CompetitionModel competition;
    private byte[] stageImage;

    public StageModel() {

    }

    public StageModel(CompetitionModel competition, byte[] stageImage) {
        super();
        this.competition = competition;
        this.stageImage = stageImage;
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
    @OneToOne
    public CompetitionModel getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionModel competition) {
        this.competition = competition;
    }

    @Column(name = "stage_img", nullable = false)
    public byte[] getStageImage() {
        return stageImage;
    }

    public void setStageImage(byte[] stageImage) {
        this.stageImage = stageImage;
    }

}
