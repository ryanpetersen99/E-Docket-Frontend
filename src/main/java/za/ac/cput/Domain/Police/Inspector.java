package za.ac.cput.Domain.Police;

public class Inspector {

    private String inspectorID, inspectorName, inspectorSurname, inspectorBadgeID;

    private Inspector(){}

    private Inspector(Builder builder){
        this.inspectorID = builder.inspectorID;
        this.inspectorName = builder.inspectorName;
        this.inspectorSurname = builder.inspectorSurname;
        this.inspectorBadgeID = builder.inspectorBadgeID;
    }

    public String getInspectorID() {
        return inspectorID;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public String getInspectorSurname() {
        return inspectorSurname;
    }

    public String getInspectorBadgeID() {
        return inspectorBadgeID;
    }

    public static class Builder{

        private String inspectorID, inspectorName, inspectorSurname, inspectorBadgeID;

        public Builder inspectorID(String inspectorID){
            this.inspectorID = inspectorID;
            return this;
        }

        public Builder inspectorName(String inspectorName){
            this.inspectorName = inspectorName;
            return this;
        }

        public Builder inspectorSurname(String inspectorSurname){
            this.inspectorSurname = inspectorSurname;
            return this;
        }

        public Builder inspectorBadgeID(String inspectorBadgeID){
            this.inspectorBadgeID = inspectorBadgeID;
            return this;
        }

        public Builder copy(Inspector inspector){
            this.inspectorID = inspector.inspectorID;
            this.inspectorName = inspector.inspectorName;
            this.inspectorSurname = inspector.inspectorSurname;
            this.inspectorBadgeID = inspector.inspectorBadgeID;
            return this;
        }

        public Inspector build(){
            return new Inspector(this);
        }
    }

    public String toString(){
        return "Inspector Details" + "\n" + "ID: " + inspectorID + "\n" + "Name: " + inspectorName + "\n" + "Surname: " + inspectorSurname + "\n" + "Badge ID: " + inspectorBadgeID;
    }
}
