package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "squads")
public class SquadModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer squadNumber;
    private CompetitionModel competition;

    public SquadModel() {

    }

    public SquadModel(Integer squadNumber, CompetitionModel competition) {
        super();
        this.squadNumber = squadNumber;
        this.competition = competition;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number", nullable = false)
    public Integer getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(Integer squadNumber) {
        this.squadNumber = squadNumber;
    }

    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    @ManyToOne
    public CompetitionModel getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionModel competition) {
        this.competition = competition;
    }
}
