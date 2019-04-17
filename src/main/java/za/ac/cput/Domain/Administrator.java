package za.ac.cput.Domain;

public class Administrator {

    private String adminID, adminName, adminSurname;

    public Administrator(){}

    private Administrator(Builder builder){
        this.adminID = builder.adminID;
        this.adminName = builder.adminName;
        this.adminSurname = builder.adminSurname;
    }

    public String getAdminID(){
        return adminID;
    }

    public String getAdminName(){
        return adminName;
    }

    public String getAdminSurname(){
        return adminSurname;
    }

    public static class Builder{

        private String adminID, adminName, adminSurname;

        public Builder adminID(String adminID){
            this.adminID = adminID;
            return this;
        }

        public Builder adminName(String adminName){
            this.adminName = adminName;
            return this;
        }

        public Builder adminSurname(String adminSurname){
            this.adminSurname = adminSurname;
            return this;
        }

        public Administrator build(){
            return new Administrator(this);
        }
    }

    public String toString(){
        return "Administrator Details " + "\n" + "ID: " + adminID + "\n" + "Name: " + adminName + "\n" + "Surname: " + adminSurname;
    }
}
