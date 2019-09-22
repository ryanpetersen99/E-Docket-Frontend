package za.ac.cput.domain.Police;

public class EvidenceTechnician {

    private String evidenceTechID, evidenceTechName, evidenceTechSurname, evidenceTechBadgeID;

    private EvidenceTechnician() {
    }

    private EvidenceTechnician(Builder builder) {
        this.evidenceTechID = builder.evidenceTechID;
        this.evidenceTechName = builder.evidenceTechName;
        this.evidenceTechSurname = builder.evidenceTechSurname;
        this.evidenceTechBadgeID = builder.evidenceTechBadgeID;
    }

    public String getEvidenceTechID() {
        return evidenceTechID;
    }

    public String getEvidenceTechName() {
        return evidenceTechName;
    }

    public String getEvidenceTechSurname() {
        return evidenceTechSurname;
    }

    public String getEvidenceTechBadgeID() {
        return evidenceTechBadgeID;
    }

    public String setEvidenceTechID(String evidenceTechID) {
        return this.evidenceTechBadgeID = evidenceTechID;
    }

    public String setEvidenceTechName(String evidenceTechName) {
        return this.evidenceTechName = evidenceTechName;
    }

    public String setEvidenceTechSurname(String evidenceTechSurname) {
        return this.evidenceTechSurname = evidenceTechSurname;
    }

    public String setEvidenceTechBadgeID(String evidenceTechBadgeID) {
        return this.evidenceTechBadgeID = evidenceTechBadgeID;
    }

    public static class Builder {

        private String evidenceTechID, evidenceTechName, evidenceTechSurname, evidenceTechBadgeID;

        public Builder evidenceTechID(String evidenceTechID) {
            this.evidenceTechID = evidenceTechID;
            return this;
        }

        public Builder evidenceTechName(String evidenceTechName) {
            this.evidenceTechName = evidenceTechName;
            return this;
        }

        public Builder evidenceTechSurname(String evidenceTechSurname) {
            this.evidenceTechSurname = evidenceTechSurname;
            return this;
        }

        public Builder evidenceTechBadgeID(String evidenceTechBadgeID) {
            this.evidenceTechBadgeID = evidenceTechBadgeID;
            return this;
        }

        public Builder copy(EvidenceTechnician evidenceTechnician) {
            this.evidenceTechID = evidenceTechnician.evidenceTechID;
            this.evidenceTechName = evidenceTechnician.evidenceTechName;
            this.evidenceTechSurname = evidenceTechnician.evidenceTechSurname;
            this.evidenceTechBadgeID = evidenceTechnician.evidenceTechBadgeID;
            return this;
        }

        public EvidenceTechnician build() {
            return new EvidenceTechnician(this);
        }
    }

    public String toString() {
        return "Evidence Technician Details" + "\n" + "ID: " + evidenceTechID + "\n" + "Name: " + evidenceTechName + "\n" + "Surname: " + evidenceTechSurname + "\n" + "Badge ID: " + evidenceTechBadgeID;
    }
}
