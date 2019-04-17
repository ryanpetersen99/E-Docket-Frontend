package za.ac.cput.Domain;

public class Evidence {
    private String evidenceID,evidenceDetails;

    private Evidence(){}

    private Evidence(Builder builder){
        this.evidenceID = builder.evidenceID;
        this.evidenceDetails = builder.evidenceDetails;
    }

    public String getEvidenceID() {
        return evidenceID;
    }

    public String getEvidenceDetails() {
        return evidenceDetails;
    }

    public static class Builder{

        private String evidenceID,evidenceDetails;

        public Builder evidenceID(String evidenceID){
            this.evidenceID = evidenceID;
            return this;
        }

        public Builder evidenceDetails(String evidenceDetails){
            this.evidenceDetails = evidenceDetails;
            return this;
        }

        public Evidence build(){
            return new Evidence(this);
        }
    }

    public String toString(){
        return "Evidence ID: " + evidenceID + "\n" + "Evidence Details: " + evidenceDetails;
    }
}
