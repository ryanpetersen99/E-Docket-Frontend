package za.ac.cput.domain.Civilian;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Complainant {

    private String complainantID, complainantName, complainantSurname, complainantStatement;

    public Complainant() {
    }

    private Complainant(Builder builder) {
        this.complainantID = builder.complainantID;
        this.complainantName = builder.complainantName;
        this.complainantSurname = builder.complainantSurname;
        this.complainantStatement = builder.complainantStatement;
    }

    public String getComplainantID() {
        return complainantID;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public String getComplainantSurname() {
        return complainantSurname;
    }

    public String getComplainantStatement() {
        return complainantStatement;
    }

    public String setComplainantID(String complainantID) {
        return this.complainantID = complainantID;
    }

    public String setComplainantName(String complainantName) {
        return this.complainantName = complainantName;
    }

    public String setComplainantSurname(String complainantSurname) {
        return this.complainantSurname = complainantSurname;
    }

    public String setComplainantStatement(String complainantStatement) {
        return this.complainantStatement = complainantStatement;
    }

    public static class Builder {

        private String complainantID, complainantName, complainantSurname, complainantStatement;

        public Builder complainantID(String complainantID) {
            this.complainantID = complainantID;
            return this;
        }

        public Builder complainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }

        public Builder complainantSurname(String complainantSurname) {
            this.complainantSurname = complainantSurname;
            return this;
        }

        public Builder complainantStatement(String complainantStatement) {
            this.complainantStatement = complainantStatement;
            return this;
        }

        public Builder copy(Complainant complainant) {
            this.complainantID = complainant.complainantID;
            this.complainantName = complainant.complainantName;
            this.complainantSurname = complainant.complainantSurname;
            this.complainantStatement = complainant.complainantStatement;
            return this;
        }

        public Complainant build() {
            return new Complainant(this);
        }
    }

    public String toString() {
        return "Complainant Details" + "\n" + "ID: " + complainantID + "\n" + "Name: " + complainantName + "\n" + "Surname: " + complainantSurname + "\n" + "Statement: " + complainantStatement;
    }

}
