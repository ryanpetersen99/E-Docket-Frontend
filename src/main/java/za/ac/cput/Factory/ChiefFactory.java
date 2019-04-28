package za.ac.cput.Factory;

import za.ac.cput.Domain.Chief;

public class ChiefFactory {

    public static Chief getChief(String chiefID,String chiefName,String chiefSurname,String chiefBadgeID){
        return new Chief.Builder().chiefID(chiefID).chiefName(chiefName).chiefSurname(chiefSurname).chiefBadgeID(chiefBadgeID).build();
    }
}
