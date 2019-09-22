package za.ac.cput.factory.Police;


import za.ac.cput.domain.Police.Inspector;

public class InspectorFactory {

    public static Inspector getInspector(String inspectorID, String inspectorName, String inspectorSurname, String inspectorBadgeID) {
        return new Inspector.Builder().inspectorID(inspectorID).inspectorName(inspectorName).inspectorSurname(inspectorSurname).inspectorBadgeID(inspectorBadgeID).build();
    }
}
