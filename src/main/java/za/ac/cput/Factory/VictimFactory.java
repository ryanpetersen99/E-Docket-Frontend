package za.ac.cput.Factory;

import za.ac.cput.Domain.Victim;

public class VictimFactory {

    public static Victim getVictim(String victimID, String victimName, String victimSurname,String statement){
        return new Victim.Builder().victimID(victimID).victimName(victimName).victimSurname(victimSurname).statement(statement).build();
    }
}
