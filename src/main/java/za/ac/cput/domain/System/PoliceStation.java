package za.ac.cput.domain.System;

public class PoliceStation {

    private String stationName,number;

    private PoliceStation() {
    }

    private PoliceStation(Builder builder) {
        this.stationName = builder.stationName;
        this.number = builder.number;
    }

    public String getStationName() {
        return stationName;
    }
    public String getStationNum() {
        return number;
    }

    public String setStationName(String stationName) {
        return this.stationName = stationName;
    }
    public String setStationNum(String number) {
        return this.number = number;
    }

    public static class Builder {

        private String stationName,number;

        public Builder stationName(String stationName) {
            this.stationName = stationName;
            return this;
        }
        public Builder stationNum(String number) {
            this.number = number;
            return this;
        }

        public Builder copy(PoliceStation policeStation) {
            this.stationName = policeStation.stationName;
            this.number = policeStation.number;
            return this;
        }

        public PoliceStation build() {
            return new PoliceStation(this);
        }
    }

    public String toString() {
        return "Police Station name: " + stationName + number;
    }
}
