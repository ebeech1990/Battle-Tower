import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPokemon {
    private Pokemon growlithe;
    private Pokemon tentacool;
    private Pokemon rowlet;
    private Pokemon gengar;
    private Pokemon rattata;
    @Before
    public void init(){
         growlithe = new Pokemon("Growlithe", Types.FIRE);
         tentacool = new Pokemon("Tentacool", Types.WATER);
         rowlet = new Pokemon("Rowlet", Types.GRASS);
         gengar = new Pokemon("Gengar", Types.GHOST);
         rattata = new Pokemon("Rattata", Types.NORMAL);
    }

    @Test
    public void testBattle1(){
        Pokemon a = growlithe;
        Pokemon b = tentacool;
        String winner =  a.battle(b);
        Assert.assertEquals(tentacool.getName(),winner);
    }

    @Test
    public void testBattle2(){
        Pokemon a = rowlet;
        Pokemon b = tentacool;
        String winner =  a.battle(b);
        Assert.assertEquals(rowlet.getName(),winner);
    }

    @Test
    public void testBattle3(){
        Pokemon a = rattata;
        Pokemon b = gengar;
        String winner =  a.battle(b);
        Assert.assertEquals(rattata.getName(),winner);
    }


}
