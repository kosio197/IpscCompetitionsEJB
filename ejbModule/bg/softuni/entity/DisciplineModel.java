package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "disciplineByName", query = "SELECT c FROM DisciplineModel c WHERE c.name = :disciplineName")
@Entity
@Table(name = "disciplines")
public class DisciplineModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public DisciplineModel() {
    }

    public DisciplineModel(String name) {
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
