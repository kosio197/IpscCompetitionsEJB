package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "hdmByNameAndPowerFactor", query = "select c from HandgunDivisionModel c, PowerFactorModel p "
        + "where c.name = :hdmName and p.name = :pfName and c.powerfactor.id=p.id")
@Entity
@Table(name = "handgun_divisions")
public class HandgunDivisionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private PowerFactorModel powerfactor;

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

    @JoinColumn(name = "powerfactor_id", referencedColumnName = "id")
    @ManyToOne
    public PowerFactorModel getPowerfactor() {
        return powerfactor;
    }

    public void setPowerfactor(PowerFactorModel powerfactor) {
        this.powerfactor = powerfactor;
    }

}
