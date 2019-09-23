package za.ac.cput.domain.System;

public class Charge {

    private String natureOfCharge;
    private String noOfCharges;

    public Charge() {
    }

    private Charge(Builder builder) {
        this.natureOfCharge = builder.natureOfCharge;
        this.noOfCharges = builder.noOfCharges;
    }

    public String getNoOfCharges() {
        return noOfCharges;
    }

    public String getNatureOfCharge() {
        return natureOfCharge;
    }

    public String setNoOfCharges(String noOfCharges) {
        return this.noOfCharges = noOfCharges;
    }

    public String setNatureOfCharge(String natureOfCharge) {
        return this.natureOfCharge = natureOfCharge;
    }

    public static class Builder {

        private String natureOfCharge;
        private String noOfCharges;

        public Builder natureOfCharge(String natureOfCharge) {
            this.natureOfCharge = natureOfCharge;
            return this;
        }

        public Builder noOfChargers(String noOfChargers) {
            this.noOfCharges = noOfChargers;
            return this;
        }

        public Builder copy(Charge charge) {
            this.natureOfCharge = charge.natureOfCharge;
            this.noOfCharges = charge.noOfCharges;
            return this;
        }

        public Charge build() {
            return new Charge(this);
        }
    }

    public String toString() {
        return "Suspect is charged with: " + "\n" + natureOfCharge + "\n" + "Amount of chargers: " + noOfCharges;
    }
}
