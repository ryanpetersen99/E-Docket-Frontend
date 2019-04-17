package za.ac.cput.Domain;

public class PoliceStation {

    private String stationName;

    private PoliceStation(){}

    private PoliceStation(Builder builder){
        this.stationName = builder.stationName;
    }

    public String getStationName(){
        return stationName;
    }

    public static class Builder{

        private String stationName;

        public Builder stationName(String stationName){
            this.stationName = stationName;
            return this;
        }

        public PoliceStation build(){
            return new PoliceStation(this);
        }
    }

    public String toString(){
        return "Police Station name: " + stationName;
    }
}
