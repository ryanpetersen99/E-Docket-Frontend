package za.ac.cput.domain.Police;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Column(name = "surname")
    private String surname;

    @Column(name = "badNO")
    private String badgeNO;


    public Inspector() {}

    public Inspector(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBadgeNO(String badgeNO) {
        this.badgeNO = badgeNO;
    }
    public String getBadgeNO() {
        return badgeNO;
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}

