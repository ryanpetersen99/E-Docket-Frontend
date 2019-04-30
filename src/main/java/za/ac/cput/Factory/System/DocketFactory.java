package za.ac.cput.Factory.System;

import za.ac.cput.Domain.System.Docket;

public class DocketFactory {

    public static Docket getDocket(String docketID){
        return new Docket.Builder().docketID(docketID).build();
    }
}
