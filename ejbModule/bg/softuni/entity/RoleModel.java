package bg.softuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import competition.bg.softuni.model.enumeration.Role;

@Entity
@Table(name = "roles")
public class RoleModel {

    private Integer id;
    private Role name;

    public RoleModel() {
    }

    public RoleModel(Integer id, Role name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

}
