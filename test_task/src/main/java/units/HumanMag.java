package units;

import game.Team;
import org.apache.log4j.Logger;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class HumanMag extends Mag {

    private String simpleAttack = " атакует магией ";
    private int damage = 4;

    public HumanMag(int id, Team team, Logger logger){
        setName(getName()+id);
        setMyTeam(team);
        setLogger(logger);
    }


    @Override
    protected int getDamage() {
        return damage;
    }

    @Override
    protected String getSimpleAttack() {
        return simpleAttack;
    }

}
