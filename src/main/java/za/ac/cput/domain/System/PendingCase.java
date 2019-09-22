package za.ac.cput.domain.System;

public class PendingCase {

    private String caseID, caseDetails, dateOpened;
    private int caseNoOfDockets;

    private PendingCase() {
    }

    private PendingCase(Builder builder) {
        this.caseID = builder.caseID;
        this.caseDetails = builder.caseDetails;
        this.caseNoOfDockets = builder.caseNoOfDockets;
        this.dateOpened = builder.dateOpened;
    }

    public String getCaseID() {
        return caseID;
    }

    public String getCaseDetails() {
        return caseDetails;
    }

    public Integer getCaseNoOfDockets() {
        return caseNoOfDockets;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public String setCaseID(String caseID) {
        return this.caseID = caseID;
    }

    public String setCaseDetails(String caseDetails) {
        return this.caseDetails = caseDetails;
    }

    public Integer setCaseNoOfDockets(Integer caseNoOfDockets) {
        return this.caseNoOfDockets = caseNoOfDockets;
    }

    public String setDateOpened(String dateOpened) {
        return this.dateOpened = dateOpened;
    }

    public static class Builder {

        private String caseID, caseDetails, dateOpened;
        private Integer caseNoOfDockets;

        public Builder caseID(String caseID) {
            this.caseID = caseID;
            return this;
        }

        public Builder caseDetails(String caseDetails) {
            this.caseDetails = caseDetails;
            return this;
        }

        public Builder dateOpened(String dateOpened) {
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder caseNoOfDockets(Integer caseNoOfDockets) {
            this.caseNoOfDockets = caseNoOfDockets;
            return this;
        }

        public Builder copy(PendingCase pendingCase) {
            this.caseID = pendingCase.caseID;
            this.caseNoOfDockets = pendingCase.caseNoOfDockets;
            this.caseDetails = pendingCase.caseDetails;
            this.dateOpened = pendingCase.dateOpened;
            return this;
        }

        public PendingCase build() {
            return new PendingCase(this);
        }
    }

    public String toString() {
        return "Case Details" + "\n" + "Case ID: " + caseID + "\n" + "Details of Case: " + caseDetails + "\n" + "Number of dockets in case: " + caseNoOfDockets + "\n" + "Date Opened: " + dateOpened;
    }
}
