package za.ac.cput.Domain.System;

public class SolvedCase {

    private String caseID,caseDetails , dateSolved;
    private  int caseNoOfDockets;

    private SolvedCase(){}

    private SolvedCase(Builder builder){
        this.caseID = builder.caseID;
        this.caseDetails =builder.caseDetails;
        this.caseNoOfDockets = builder.caseNoOfDockets;
        this.dateSolved = builder.dateSolved;
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

    public String getDateSolved() { return dateSolved; }

    public static class Builder{

        private String caseID,caseDetails,dateSolved;
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

        public Builder dateSolved(String dateSolved){
            this.dateSolved = dateSolved;
            return this;
        }

        public Builder copy(SolvedCase solvedCase){
            this.caseID = solvedCase.caseID;
            this.caseNoOfDockets = solvedCase.caseNoOfDockets;
            this.caseDetails = solvedCase.caseDetails;
            this.dateSolved = solvedCase.dateSolved;
            return this;
        }

        public SolvedCase build(){
            return new SolvedCase(this);
        }
    }

    public String toString(){
        return "Case Details" + "\n" + "Case ID: " + caseID + "\n" + "Details of Case: " + caseDetails + "\n" + "Number of dockets in case: " + caseNoOfDockets + "\n" + "Date Solved: " + dateSolved;
    }
}
