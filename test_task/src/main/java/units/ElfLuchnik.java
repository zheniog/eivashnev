package units;

import game.Team;
import org.apache.log4j.Logger;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class ElfLuchnik extends Luchnik{

    public ElfLuchnik(int id, Team team, Logger logger){
        setName(getName()+id);
        setMyTeam(team);
        setLogger(logger);
    }
}
