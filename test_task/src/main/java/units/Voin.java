package units;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class Voin extends Unit {

    private int hp = 100;
    private String name = "Воин";
    private String simpleAttack = " атакует мечом ";

    @Override
    protected String getSimpleAttack() {
        return simpleAttack;
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

}
