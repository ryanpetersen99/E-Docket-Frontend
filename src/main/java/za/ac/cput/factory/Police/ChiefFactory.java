package za.ac.cput.factory.Police;

import za.ac.cput.domain.Police.Chief;

public class ChiefFactory {

    public static Chief getChief(String chiefID, String chiefName, String chiefSurname, String chiefBadgeID) {
        return new Chief.Builder().chiefID(chiefID).chiefName(chiefName).chiefSurname(chiefSurname).chiefBadgeID(chiefBadgeID).build();
    }
}
