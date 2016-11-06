package bg.softuni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import competition.bg.softuni.model.enumeration.Category;

@Entity
@Table(name = "categories")
public class CategoryModel {

    private Integer id;
    private Category name;

    public CategoryModel() {
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
    public Category getName() {
        return name;
    }

    public void setName(Category name) {
        this.name = name;
    }
}
