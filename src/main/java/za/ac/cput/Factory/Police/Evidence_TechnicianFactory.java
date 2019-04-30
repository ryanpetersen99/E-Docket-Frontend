package za.ac.cput.Factory.Police;

import za.ac.cput.Domain.Police.EvidenceTechnician;

public class Evidence_TechnicianFactory {

    public static EvidenceTechnician getEvidence_Technician(String evidenceTechID, String evidenceTechName, String evidenceTechSurname, String evidenceTechBadgeID){
        return new EvidenceTechnician.Builder().evidenceTechID(evidenceTechID).evidenceTechName(evidenceTechName).evidenceTechSurname(evidenceTechSurname).evidenceTechBadgeID(evidenceTechBadgeID).build();
    }
}
