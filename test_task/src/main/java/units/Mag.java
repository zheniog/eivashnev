package units;

import game.Team;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class Mag extends Unit {

    private String name = "Маг";

    private String magicMove = " накладывает улучшение на ";

    private String simpleAttack = " наносит урон магией ";

    @Override
    protected String getName() {
        return name;
    }

    protected String getMagicMove() {
        return magicMove;
    }

    @Override
    protected String getSimpleAttack() {
        return simpleAttack;
    }

    protected void magicMove(Unit target){
        target.setPower(1.5);
        getLogger().info(getName()+getMagicMove()+target.getName());
    }

    public void move(Team myTeam, Team enemyTeam){
        int action;

        if(myTeam.getUnits().size()==1){
            action=1;
        }else{
            action = new Random().nextInt(2);
        }

        switch(action){
            case 0:
                //improve teammate
                Unit mate = myTeam.getUnits().get(ThreadLocalRandom.current().nextInt(1,myTeam.getUnits().size()));
                magicMove(mate);
                myTeam.getPrivelegeUnits().add(mate);
                break;
            case 1:
                //attack
                Unit enemy = enemyTeam.getUnits().get(ThreadLocalRandom.current().nextInt(0,enemyTeam.getUnits().size()));
                attack(enemy);
                break;
        }
    }
}
