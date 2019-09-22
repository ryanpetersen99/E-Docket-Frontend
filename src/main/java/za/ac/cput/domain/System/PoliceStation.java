package za.ac.cput.domain.System;

public class PoliceStation {

    private String stationName;

    private PoliceStation() {
    }

    private PoliceStation(Builder builder) {
        this.stationName = builder.stationName;
    }

    public String getStationName() {
        return stationName;
    }

    public String setStationName(String stationName) {
        return this.stationName = stationName;
    }

    public static class Builder {

        private String stationName;

        public Builder stationName(String stationName) {
            this.stationName = stationName;
            return this;
        }

        public Builder copy(PoliceStation policeStation) {
            this.stationName = policeStation.stationName;
            return this;
        }

        public PoliceStation build() {
            return new PoliceStation(this);
        }
    }

    public String toString() {
        return "Police Station name: " + stationName;
    }
}
