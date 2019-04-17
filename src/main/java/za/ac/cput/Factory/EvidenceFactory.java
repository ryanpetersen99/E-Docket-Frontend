package za.ac.cput.Factory;

import za.ac.cput.Domain.Evidence;

public class EvidenceFactory {

    public static Evidence getEvidence(String evidenceID,String evidenceDetails){
        return new Evidence.Builder().evidenceID(evidenceID).evidenceDetails(evidenceDetails).build();
    }
}
