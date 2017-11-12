package units;

import game.Team;
import org.apache.log4j.Logger;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class ElfMag extends Mag {

    private int damage = 10;

    public ElfMag(int id, Team team, Logger logger){
        setName(getName()+id);
        setMyTeam(team);
        setLogger(logger);
    }


    @Override
    protected int getDamage() {
        return damage;
    }


}
