package za.ac.cput.Factory.Police;


import za.ac.cput.Domain.Police.Inspector;

public class InpsectorFactory {

    public static Inspector getInspector(String inspectorID, String inspectorName, String inspectorSurname, String inspectorBadgeID){
        return new Inspector.Builder().inspectorID(inspectorID).inspectorName(inspectorName).inspectorSurname(inspectorSurname).inspectorBadgeID(inspectorBadgeID).build();
    }
}
