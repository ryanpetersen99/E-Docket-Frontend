package za.ac.cput.Factory.Police;

import za.ac.cput.Domain.Police.DataAnalyst;

public class DataAnalystFactory {

    public static DataAnalyst getDataAnalyst(String daID,String name,String surname){
        return new DataAnalyst.Builder().daID(daID).daName(name).daSurname(surname).build();
    }
}
