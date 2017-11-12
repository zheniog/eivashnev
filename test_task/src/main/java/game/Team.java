package game;

import org.apache.log4j.Logger;
import units.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by Evgeny on 12.11.2017.
 */
public class Team {

    private List<Unit> privelegeUnits = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();

    private Race race;
    private int numberOfLuckniks = 3;
    private int numberOfVoins = 4;
    private Logger logger;

    private Team enemyTeam;

    public Team(Race race, Logger logger){
        this.race = race;
        this.logger = logger;

        switch(race){
            case ELF:
                units.add(new ElfMag(1,this,logger));
                for(int i=0;i<numberOfLuckniks;i++) units.add(new ElfLuchnik(i+1,this,logger));
                for(int i=0;i<numberOfVoins;i++) units.add(new ElfVoin(i+1,this,logger));
                break;
            case NEZHIT:
                units.add(new NezhitMag());
                for(int i=0;i<numberOfLuckniks;i++) units.add(new NezhitLuchnik());
                for(int i=0;i<numberOfVoins;i++) units.add(new NezhitVoin());
                break;
            case HUMAN:
                units.add(new HumanMag(1,this,logger));
                for(int i=0;i<numberOfLuckniks;i++) units.add(new HumanLuchnik(i+1,this,logger));
                for(int i=0;i<numberOfVoins;i++) units.add(new HumanVoin(i+1,this,logger));
                break;
            case ORK:
                units.add(new OrkMag());
                for(int i=0;i<numberOfLuckniks;i++) units.add(new OrkLuchnik());
                for(int i=0;i<numberOfVoins;i++) units.add(new OrkVoin());
                break;
        }

    }

    public void move(){
        if(isAlive()){
            logger.info("Ходит отряд ["+this.race+"]: ");
            getRandomMate().move(this, enemyTeam);
        }
    }

    public boolean isAlive(){
        return !units.isEmpty();
    }

    public Team getEnemyTeam() {
        return enemyTeam;
    }

    public void setEnemyTeam(Team enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public Race getRace() {
        return race;
    }

    public List<Unit> getPrivelegeUnits() {
        return privelegeUnits;
    }

    public List<Unit> getUnits() {
        return units;
    }

    protected Unit getRandomMate(){
        return getUnits().get(new Random().nextInt(getUnits().size()));
    }


}
