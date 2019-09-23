package za.ac.cput.factory.System;

import za.ac.cput.domain.System.Docket;

public class DocketFactory {

    public static Docket getDocket(String docketID,String date) {
        return new Docket.Builder().docketID(docketID).docketDate(date).build();
    }
}
