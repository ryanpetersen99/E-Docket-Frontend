package za.ac.cput.domain.Civilian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Convict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_no")
    private long phoneNo;

    @Column(name = "natureofconviction")
    private String natureofconviction;

    public Convict() {}

    public Convict(String name, String surname) {
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

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setconviction(String natureofconviction) {
        this.natureofconviction = natureofconviction;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getconviction() {
        return natureofconviction;
    }
}

