package za.ac.cput.Factory;

import za.ac.cput.Domain.Docket;

public class DocketFactory {

    public static Docket getDocket(String docketID){
        return new Docket.Builder().docketID(docketID).build();
    }
}
