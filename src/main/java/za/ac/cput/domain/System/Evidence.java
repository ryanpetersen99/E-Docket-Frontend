package za.ac.cput.domain.System;

public class Evidence {
    private String evidenceID, evidenceDetails;

    private Evidence() {
    }

    private Evidence(Builder builder) {
        this.evidenceID = builder.evidenceID;
        this.evidenceDetails = builder.evidenceDetails;
    }

    public String getEvidenceID() {
        return evidenceID;
    }

    public String getEvidenceDetails() {
        return evidenceDetails;
    }

    public String setEvidenceID(String evidenceID) {
        return this.evidenceID = evidenceID;
    }

    public String setEvidenceDetails(String evidenceDetails) {
        return this.evidenceDetails = evidenceDetails;
    }

    public static class Builder {

        private String evidenceID, evidenceDetails;

        public Builder evidenceID(String evidenceID) {
            this.evidenceID = evidenceID;
            return this;
        }

        public Builder evidenceDetails(String evidenceDetails) {
            this.evidenceDetails = evidenceDetails;
            return this;
        }

        public Builder copy(Evidence evidence) {
            this.evidenceID = evidence.evidenceID;
            this.evidenceDetails = evidence.evidenceDetails;
            return this;
        }

        public Evidence build() {
            return new Evidence(this);
        }
    }

    public String toString() {
        return "Evidence ID: " + evidenceID + "\n" + "Evidence Details: " + evidenceDetails;
    }
}
