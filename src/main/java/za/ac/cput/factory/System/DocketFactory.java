package za.ac.cput.factory.System;

import za.ac.cput.domain.System.Docket;

public class DocketFactory {

    public static Docket getDocket(String docketID) {
        return new Docket.Builder().docketID(docketID).build();
    }
}
