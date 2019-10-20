package za.ac.cput.domain.Civilian;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

@Table(name = "Complainants")
public class Complainant {

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

    @Column(name = "statement")
    private String statement;

    public Complainant() {}

    public Complainant(String name, String surname) {
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

    public void setStatement(String statement) {
        this.statement = statement;
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

    public String getStatement() {
        return statement;
    }
}

