package za.ac.cput.Domain;

public class Chief {

    private String chiefID, chiefName, chiefSurname, chiefBadgeID;

    private Chief(){}

    private Chief(Builder builder){
        this.chiefID = builder.chiefID;
        this.chiefName = builder.chiefName;
        this.chiefSurname = builder.chiefSurname;
        this.chiefBadgeID = builder.chiefBadgeID;
    }

    public String getChiefID(){
        return chiefID;
    }

    public String getChiefName(){
        return chiefName;
    }

    public String getChiefSurname(){
        return chiefSurname;
    }

    public String getChiefBadgeID(){
        return chiefBadgeID;
    }

    public static class Builder{

        private String chiefID, chiefName, chiefSurname, chiefBadgeID;

        public Builder chiefID(String chiefID){
            this.chiefID = chiefID;
            return this;
        }

        public Builder chiefName(String chiefName){
            this.chiefName = chiefName;
            return this;
        }

        public Builder chiefSurname(String chiefSurname){
            this.chiefSurname = chiefSurname;
            return this;
        }

        public Builder chiefBadgeID(String chiefBadgeID){
            this.chiefBadgeID = chiefBadgeID;
            return this;
        }

        public Chief build(){
            return new Chief(this);
        }
    }

    public String toString(){
        return "Station Chief Details" + "\n" + "ID: " + chiefID + "\n" + "Name: " + chiefName + "\n" + "Surname: " + chiefSurname + "\n" + "Badge ID: " + chiefBadgeID;
    }
}
