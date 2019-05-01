package za.ac.cput.Domain.Civilian;

public class Complainant {

    private String complainantID, complainantName, complainantSurname, complainantStatement;

    private Complainant(){}

    private Complainant(Builder builder){
        this.complainantID = builder.complainantID;
        this.complainantName = builder.complainantName;
        this.complainantSurname = builder.complainantSurname;
        this.complainantStatement = builder.complainantStatement;
    }

    public String getComplainantID(){
        return complainantID;
    }

    public String getComplainantName(){
        return complainantName;
    }

    public String getComplainantSurname(){
        return complainantSurname;
    }

    public String getComplainantStatement(){
        return complainantStatement;
    }

    public static class Builder{

        private String complainantID, complainantName, complainantSurname, complainantStatement;

        public Builder complainantID(String complainantID){
            this.complainantID = complainantID;
            return this;
        }

        public Builder complainantName(String complainantName){
            this.complainantName = complainantName;
            return this;
        }

        public Builder complainantSurname(String complainantSurname){
            this.complainantSurname = complainantSurname;
            return this;
        }

        public Builder complainantStatement(String complainantStatement){
            this.complainantStatement = complainantStatement;
            return this;
        }

        public Builder copy(Complainant complainant){
            this.complainantID = complainant.complainantID;
            this.complainantName = complainant.complainantName;
            this.complainantSurname = complainant.complainantSurname;
            this.complainantStatement = complainant.complainantStatement;
            return this;
        }

        public Complainant build(){
            return new Complainant(this);
        }
    }

    public String toString(){
        return "Complainant Details" + "\n" + "ID: " + complainantID + "\n" + "Name: " + complainantName + "\n" + "Surname: " +complainantSurname + "\n" + "Statement: " + complainantStatement;
        }

}
