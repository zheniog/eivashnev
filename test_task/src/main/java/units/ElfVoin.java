package units;

import game.Team;
import org.apache.log4j.Logger;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class ElfVoin extends Voin {

    private int damage = 15;

    public ElfVoin(int id, Team team, Logger logger){
        setName(getName()+id);
        setMyTeam(team);
        setLogger(logger);
    }

    @Override
    protected int getDamage() {
        return damage;
    }
}
