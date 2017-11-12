package units;

import game.Team;
import org.apache.log4j.Logger;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class HumanLuchnik  extends Luchnik {
    private String name = "Арбалетчик";
    private String lukAttack = " стреляет из арбалета по ";
    private int damage = 3;
    private int lukDamage = 5;

    public HumanLuchnik(int id, Team team, Logger logger){
        setName(getName()+id);
        setMyTeam(team);
        setLogger(logger);
    }


    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    protected String getLukAttack() {
        return lukAttack;
    }

    @Override
    protected int getDamage() {
        return damage;
    }

    @Override
    protected int getLukDamage() {
        return lukDamage;
    }
}
