package za.ac.cput.domain.System;

public class Docket {

    private String docketID,date;

    private Docket() {
    }

    private Docket(Builder builder) {
        this.docketID = builder.docketID;
        this.date = builder.date;
    }

    public String getDocketID() {
        return docketID;
    }

    public String getDate() {
        return date;
    }

    public String setDocketID(String docketID) {
        return this.docketID = docketID;
    }
    public String setDate(String date) {
        return this.date = date;
    }

    public static class Builder {

        private String docketID,date;

        public Builder docketID(String docketID) {
            this.docketID = docketID;
            return this;
        }
        public Builder docketDate(String date) {
            this.date = date;
            return this;
        }

        public Builder copy(Docket docket) {
            this.docketID = docket.docketID;
            this.date = docket.date;
            return this;
        }

        public Docket build() {
            return new Docket(this);
        }
    }

    public String toString() {
        return "Docket ID: " + docketID + date;
    }
}
