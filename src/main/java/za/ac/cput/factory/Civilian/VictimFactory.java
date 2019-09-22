package za.ac.cput.factory.Civilian;

import za.ac.cput.domain.Civilian.Victim;

public class VictimFactory {

    public static Victim getVictim(String victimID, String victimName, String victimSurname, String statement) {
        return new Victim.Builder().victimID(victimID).victimName(victimName).victimSurname(victimSurname).statement(statement).build();
    }
}
