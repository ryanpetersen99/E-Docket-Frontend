package za.ac.cput.Domain;

public class Case {

    private String caseID,caseDetails;
    private  int caseNoOfDockets;

    private Case(){}

    private Case(Builder builder){
        this.caseID = builder.caseID;
        this.caseDetails =builder.caseDetails;
        this.caseNoOfDockets = builder.caseNoOfDockets;
    }

    public String getCaseID(){
        return caseID;
    }

    public String getCaseDetails() {
        return caseDetails;
    }

    public Integer getCaseNoOfDockets() {
        return caseNoOfDockets;
    }

    public static class Builder{

        private String caseID,caseDetails;
        private Integer caseNoOfDockets;

        public Builder caseID(String caseID){
            this.caseID = caseID;
            return this;
        }

        public Builder caseDetails(String caseDetails){
            this.caseDetails = caseDetails;
            return this;
        }

        public Builder caseNoOfDockets(Integer caseNoOfDockets){
            this.caseNoOfDockets = caseNoOfDockets;
            return this;
        }

        public Case build(){
            return new Case(this);
        }
    }

    public String toString(){
        return "Case Details" + "\n" + "Case ID: " + caseID + "\n" + "Details of Case: " + caseDetails + "\n" + "Number of dockets in case: " + caseNoOfDockets;
    }
}
