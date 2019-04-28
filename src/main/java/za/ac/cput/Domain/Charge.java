package za.ac.cput.Domain;

public class Charge {

    private String natureOfCharge;
    private int noOfCharges;

    private Charge(){}

    private Charge(Builder builder){
        this.natureOfCharge = builder.natureOfCharge;
        this.noOfCharges = builder.noOfCharges;
    }

    public int getNoOfCharges() {
        return noOfCharges;
    }

    public String getNatureOfCharge() {
        return natureOfCharge;
    }

    public static class Builder{

        private String natureOfCharge;
        private int noOfCharges;

        public Builder natureOfCharge(String natureOfCharge){
            this.natureOfCharge = natureOfCharge;
            return this;
        }

        public Builder noOfChargers(int noOfChargers){
            this.noOfCharges = noOfChargers;
            return this;
        }

    public Charge build(){
            return new Charge(this);
        }
    }

    public String toString(){
        return "Suspect is charged with: " + "\n"  + natureOfCharge + "\n" + "Amount of chargers: " + noOfCharges;
    }
}
