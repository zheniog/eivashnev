package units;

import game.Team;
import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class Unit {

    private String name;
    private int damage;
    private double power = 1;
    private int hp = 100;
    private String simpleAttack = " атакует ";
    private Team myTeam;

    private Logger logger;

    public void setLogger(Logger logger){
        this.logger=logger;
    }

    public Logger getLogger(){
        return logger;
    }

    protected Team getMyTeam() {
        return myTeam;
    }

    protected void setMyTeam(Team myTeam) {
        this.myTeam = myTeam;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getHp() {
        return hp;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    protected int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    protected double getPower() {
        return power;
    }

    protected void setPower(double power) {
        this.power = power;
    }

    protected String getSimpleAttack() {
        return simpleAttack;
    }

    public void makeDamage(int damage){
        setHp(getHp()-damage);

        if(getHp()<=0){
            logger.info(getName()+" умер ");
            //remove unit from team lists if dead
            getMyTeam().getUnits().remove(this);
            if(getMyTeam().getPrivelegeUnits().contains(this)){
                getMyTeam().getPrivelegeUnits().remove(this);
            }
        }
    }

    public void move(Team myTeam, Team enemyTeam){
        Unit enemy = enemyTeam.getUnits().get(ThreadLocalRandom.current().nextInt(0,enemyTeam.getUnits().size()));
        attack(enemy);
    }

    public void attack(Unit target){
        int damage = (int)(getDamage()*getPower());
        target.makeDamage(damage);
        getLogger().info(getName()+getSimpleAttack()+target.getName()+" , " +
                "урон: -"+damage+"HP -> "+target.getName()+"["+target.getHp()+"]");
        setPower(1);
    }

}
