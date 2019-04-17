package za.ac.cput.Domain;

public class Witness {

    private String witnessID, witnessName, witnessSurname, witnessStatement;

    private Witness(){}

    private Witness(Builder builder){
        this.witnessID = builder.witnessID;
        this.witnessName = builder.witnessName;
        this.witnessSurname = builder.witnessSurname;
        this.witnessStatement = builder.witnessStatement;
    }

    public String getWitnessID(){
        return witnessID;
    }

    public String getWitnessName(){
        return witnessName;
    }

    public String getWitnessSurname(){
        return witnessSurname;
    }

    public String getWitnessStatement(){
        return witnessStatement;
    }

    public static class Builder{

        private String witnessID, witnessName, witnessSurname, witnessStatement;

        public Builder witnessID(String witnessID){
            this.witnessID = witnessID;
            return this;
        }

        public Builder witnessName(String witnessName){
            this.witnessName = witnessName;
            return this;
        }

        public Builder witnessSurname(String witnessSurname){
            this.witnessSurname = witnessSurname;
            return this;
        }

        public Builder witnessStatement(String witnessStatement){
            this.witnessStatement = witnessStatement;
            return this;
        }

        public Witness build(){
            return new Witness(this);
        }
    }

    public String toString(){
        return "Witness Details" + "\n" + "ID: " + witnessID + "\n" + "Name: " + witnessName + "\n" + "Surname: " + witnessSurname + "\n" + "Statement: " + witnessStatement;
    }
}
