package za.ac.cput.Domain.Civillian;

public class Victim {

    private String victimID, victimName, victimSurname, statement;

    private Victim(){}

    private Victim(Builder builder){
        this.victimID = builder.victimID;
        this.victimName = builder.victimName;
        this.victimSurname = builder.victimSurname;
        this.statement = builder.statement;
    }

    public String getVictimID() {
        return victimID;
    }

    public String getVictimName() {
        return victimName;
    }

    public String getVictimSurname() {
        return victimSurname;
    }

    public String getStatement() {
        return statement;
    }

    public static class Builder{

        private String victimID, victimName, victimSurname, statement;

        public Builder victimID(String victimID){
            this.victimID = victimID;
            return this;
        }

        public Builder victimName(String victimName){
            this.victimName = victimName;
            return this;
        }

        public Builder victimSurname(String victimSurname){
            this.victimSurname = victimSurname;
            return this;
        }

        public Builder statement(String statement){
            this.statement = statement;
            return this;
        }

        public Builder copy(Victim victim){
            this.victimID = victim.victimID;
            this.victimName = victim.victimName;
            this.victimSurname = victim.victimSurname;
            this.statement = victim.statement;
            return this;
        }

        public Victim build(){
            return new Victim(this);
        }
    }

    public String toString(){
        return "Victim Details" + "\n" + "ID: " + victimID + "\n" + "Name: " + victimName + "\n" + "Surname: " + victimSurname + "\n" + "Statement: " + statement;
    }
}
