package za.ac.cput.Factory;

import za.ac.cput.Domain.DataAnalyst;
import za.ac.cput.Domain.Docket;

public class DataAnalystFactory {

    public static DataAnalyst getDataAnalyst(String daID,String name,String surname){
        return new DataAnalyst.Builder().daID(daID).daName(name).daSurname(surname).build();
    }
}
