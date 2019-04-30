package za.ac.cput.Factory.Civillian;

import za.ac.cput.Domain.Civillian.Victim;

public class VictimFactory {

    public static Victim getVictim(String victimID, String victimName, String victimSurname,String statement){
        return new Victim.Builder().victimID(victimID).victimName(victimName).victimSurname(victimSurname).statement(statement).build();
    }
}
