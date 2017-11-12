package units;

import game.Team;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class Luchnik extends Unit {

    private int damage = 3;
    private int lukdamage = 7;


    private String name = "Лучник";
    private String lukAttack = " стреляет из лука по ";

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void setName(String name) {
        this.name = name;
    }

    protected int getDamage() {
        return damage;
    }

    protected int getLukDamage() {
        return lukdamage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    protected String getLukAttack() {
        return lukAttack;
    }

    public void shoot(Unit target) {
        int damage = (int) (getLukDamage() * getPower());
        target.makeDamage(damage);
        getLogger().info(getName() + getLukAttack() + target.getName() + " , " +
                "урон: -" + damage + "HP -> " + target.getName() + "[" + target.getHp() + "]");
        setPower(1);
    }

    public void attack(Unit target) {
        int damage = (int) (getDamage() * getPower());
        target.makeDamage(damage);
        getLogger().info(getName() + getSimpleAttack() + target.getName() + " , " +
                "урон: -" + damage + "HP -> " + target.getName() + "[" + target.getHp() + "]");
        setPower(1);
    }

    public void move(Team myTeam, Team enemyTeam) {
        int rnd = new Random().nextInt(2);
        Unit enemy = enemyTeam.getUnits().get(ThreadLocalRandom.current().nextInt(0, enemyTeam.getUnits().size()));
        switch (rnd) {
            case 0:
                //shoot
                shoot(enemy);
                break;
            case 1:
                //attack
                attack(enemy);
                break;
        }
    }
}