import game.Race;
import game.Team;
import org.apache.log4j.Logger;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        Team t1 = new Team(Race.ELF,logger);
        Team t2 = new Team(Race.HUMAN,logger);
        t1.setEnemyTeam(t2);
        t2.setEnemyTeam(t1);

        /*
         * TODO:
         *  1) Первыми ходят юниты из privelege list
         *     -удалять юниты из привелег листа после совершения хода
         *  2) Заполнить логику для классов Нежить, Орки
         *  3) Создавать отряды с рандомным типом
         */

        while(t1.isAlive() && t2.isAlive()){
            t1.move();
            t2.move();
        }

        if(t1.isAlive()){
            logger.info("Отряд ["+t1.getRace()+"] победил!");
        }
        if(t2.isAlive()){
            logger.info("Отряд ["+t2.getRace()+"] победил!");
        }

    }
}
