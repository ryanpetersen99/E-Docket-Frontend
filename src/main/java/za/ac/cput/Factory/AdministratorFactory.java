package za.ac.cput.Factory;

import za.ac.cput.Domain.Administrator;

public class AdministratorFactory {

    public static Administrator getAdministrator(String adminID,String adminSurname,String adminName){
        return new Administrator.Builder().adminID(adminID).adminName(adminName).adminSurname(adminSurname).build();
    }
}
