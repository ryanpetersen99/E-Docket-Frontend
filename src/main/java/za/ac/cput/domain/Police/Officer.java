package za.ac.cput.domain.Police;

public class Officer {

    private String officerID, officerName, officerSurname, officerBadgeID;

    private Officer() {
    }

    private Officer(Builder builder) {
        this.officerID = builder.officerID;
        this.officerName = builder.officerName;
        this.officerSurname = builder.officerSurname;
        this.officerBadgeID = builder.officerBadgeID;
    }

    public String getOfficerID() {
        return officerID;
    }

    public String getOfficerName() {
        return officerName;
    }

    public String getOfficerSurname() {
        return officerSurname;
    }

    public String getOfficerBadgeID() {
        return officerBadgeID;
    }

    public String setOfficerID(String officerID) {
        return this.officerID = officerID;
    }

    public String setOfficerName(String officerName) {
        return this.officerName = officerName;
    }

    public String setOfficerSurname(String officerSurname) {
        return this.officerSurname = officerSurname;
    }

    public String setOfficerBadgeID(String officerBadgeID) {
        return this.officerBadgeID = officerBadgeID;
    }

    public static class Builder {

        private String officerID, officerName, officerSurname, officerBadgeID;

        public Builder officerID(String officerID) {
            this.officerID = officerID;
            return this;
        }

        public Builder officerName(String officerName) {
            this.officerName = officerName;
            return this;
        }

        public Builder officerSurname(String officerSurname) {
            this.officerSurname = officerSurname;
            return this;
        }

        public Builder officerBadgeID(String officerBadgeID) {
            this.officerBadgeID = officerBadgeID;
            return this;
        }

        public Builder copy(Officer officer) {
            this.officerID = officer.officerID;
            this.officerName = officer.officerName;
            this.officerSurname = officer.officerSurname;
            this.officerBadgeID = officer.officerBadgeID;
            return this;
        }

        public Officer build() {
            return new Officer(this);
        }
    }

    public String toString() {
        return "Officer Details" + "\n" + "ID: " + officerID + "\n" + "Name: " + officerName + "\n" + "Surname: " + officerSurname + "\n" + "Badge ID: " + officerBadgeID;
    }
}
