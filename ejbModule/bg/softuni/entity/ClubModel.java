package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "clubByName", query = "SELECT c FROM ClubModel c WHERE c.name = :clubName")
@Entity
@Table(name = "clubs")
public class ClubModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public ClubModel() {
    }

    public ClubModel(String name) {
        super();
        this.name = name;
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

}
