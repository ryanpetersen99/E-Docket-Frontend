package za.ac.cput.Domain.Police;

public class DataAnalyst {

    private String daID, daName, daSurname;

    private DataAnalyst(){}

    private DataAnalyst(Builder builder){
        this.daID = builder.daID;
        this.daName = builder.daName;
        this.daSurname = builder.daSurname;
    }

    public String getDaID(){
        return daID;
    }

    public String getDaName(){
        return daName;
    }

    public String getDaSurname(){
        return daSurname;
    }

    public static class Builder{

        private String daID, daName, daSurname;

        public Builder daID(String daID){
            this.daID = daID;
            return this;
        }

        public Builder daName(String daName){
            this.daName = daName;
            return this;
        }

        public Builder daSurname(String daSurname){
            this.daSurname = daSurname;
            return this;
        }

        public Builder copy(DataAnalyst dataAnalyst){
            this.daID = dataAnalyst.daID;
            this.daName = dataAnalyst.daName;
            this.daSurname = dataAnalyst.daSurname;
            return this;
        }

        public DataAnalyst build(){
            return new DataAnalyst(this);
        }
    }

    public String toString(){
        return "Data Analyst Details" + "\n" +  "ID: " + daID + "\n" + "Name: " + daName + "\n" + "Surname: " + daSurname;
    }
}
