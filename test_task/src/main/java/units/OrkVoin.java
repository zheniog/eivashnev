package units;

/**
 * Created by Evgeny on 12.11.2017.
 */
public class OrkVoin extends Voin {

    private String name = "Гоблин";

    private String simpleAttack = " атакует дубиной ";

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected String getSimpleAttack() {
        return simpleAttack;
    }


}
