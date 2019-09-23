package za.ac.cput.domain.Civilian;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Suspect {

    private String suspectID, suspectName, suspectSurname, suspectAccusation;

    public Suspect() {
    }

    private Suspect(Builder builder) {
        this.suspectID = builder.suspectID;
        this.suspectName = builder.suspectName;
        this.suspectSurname = builder.suspectSurname;
        this.suspectAccusation = builder.suspectAccusation;
    }

    public String getSuspectID() {
        return suspectID;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public String getSuspectSurname() {
        return suspectSurname;
    }

    public String getSuspectAccusation() {
        return suspectAccusation;
    }

    public String setSuspectID(String suspectID) {
        return this.suspectID = suspectID;
    }

    public String setSuspectName(String suspectName) {
        return this.suspectName = suspectName;
    }

    public String setSuspectSurname(String suspectSurname) {
        return this.suspectSurname = suspectSurname;
    }

    public String setSuspectAccusation(String suspectAccusation) {
        return this.suspectAccusation = suspectAccusation;
    }

    public static class Builder {

        private String suspectID, suspectName, suspectSurname, suspectAccusation;

        public Builder suspectID(String suspectID) {
            this.suspectID = suspectID;
            return this;
        }

        public Builder suspectName(String suspectName) {
            this.suspectName = suspectName;
            return this;
        }

        public Builder suspectSurname(String suspectSurname) {
            this.suspectSurname = suspectSurname;
            return this;
        }

        public Builder suspectAccusation(String suspectAccusation) {
            this.suspectAccusation = suspectAccusation;
            return this;
        }

        public Builder copy(Suspect suspect) {
            this.suspectID = suspect.suspectID;
            this.suspectName = suspect.suspectName;
            this.suspectSurname = suspect.suspectSurname;
            this.suspectAccusation = suspect.suspectAccusation;
            return this;
        }

        public Suspect build() {
            return new Suspect(this);
        }
    }

    public String toString() {
        return "Suspect Details" + "\n" + "ID: " + suspectID + "\n" + "Name: " + suspectName + "\n" + "Surname: " + suspectSurname + "\n" + "Accused of: " + suspectAccusation;
    }
}
