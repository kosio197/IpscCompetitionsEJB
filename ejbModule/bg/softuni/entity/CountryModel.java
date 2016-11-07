package bg.softuni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "countryByName", query = "SELECT c FROM CountryModel c WHERE c.name = :countryName")
@Entity
@Table(name = "countries")
public class CountryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private byte[] countryFlag;

    public CountryModel() {
    }

    public CountryModel(String name, byte[] countryFlag) {
        super();
        this.name = name;
        this.countryFlag = countryFlag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "img_flag", nullable = true)
    public byte[] getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(byte[] countryFlag) {
        this.countryFlag = countryFlag;
    }

}
