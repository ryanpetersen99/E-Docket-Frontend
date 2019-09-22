package za.ac.cput.factory.Police;

import za.ac.cput.domain.Police.Officer;

public class OfficerFactory {

    public static Officer getOfficer(String officerBadgeID, String officerID, String officerName, String officerSurname) {
        return new Officer.Builder().officerBadgeID(officerBadgeID).officerID(officerID).officerName(officerName).officerSurname(officerSurname).build();
    }
}
