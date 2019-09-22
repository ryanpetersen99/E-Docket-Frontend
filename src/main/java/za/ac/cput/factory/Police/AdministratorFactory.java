package za.ac.cput.factory.Police;

import za.ac.cput.domain.Police.Administrator;

public class AdministratorFactory {

    public static Administrator getAdministrator(String adminID, String adminName, String adminSurname) {
        return new Administrator.Builder().adminID(adminID).adminName(adminName).adminSurname(adminSurname).build();
    }
}
