package za.ac.cput.domain.System;

public class Charge {

    private String natureOfCharge;
    private int noOfCharges;

    private Charge() {
    }

    private Charge(Builder builder) {
        this.natureOfCharge = builder.natureOfCharge;
        this.noOfCharges = builder.noOfCharges;
    }

    public int getNoOfCharges() {
        return noOfCharges;
    }

    public String getNatureOfCharge() {
        return natureOfCharge;
    }

    public int setNoOfCharges(Integer noOfCharges) {
        return this.noOfCharges = noOfCharges;
    }

    public String setNatureOfCharge(String natureOfCharge) {
        return this.natureOfCharge = natureOfCharge;
    }

    public static class Builder {

        private String natureOfCharge;
        private int noOfCharges;

        public Builder natureOfCharge(String natureOfCharge) {
            this.natureOfCharge = natureOfCharge;
            return this;
        }

        public Builder noOfChargers(int noOfChargers) {
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
