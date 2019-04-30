package za.ac.cput.Factory.System;

import za.ac.cput.Domain.System.Evidence;

public class EvidenceFactory {

    public static Evidence getEvidence(String evidenceID,String evidenceDetails){
        return new Evidence.Builder().evidenceID(evidenceID).evidenceDetails(evidenceDetails).build();
    }
}
