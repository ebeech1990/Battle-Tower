import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestPokemon {
    private Pokemon growlithe;
    private Pokemon tentacool;
    private Pokemon rowlet;
    private Pokemon gengar;
    private Pokemon rattata;
    private Pokemon arbok;
    private List<Moves> agathaArbok;
    private List<Moves> joeyRattata;

    @Before
    public void init(){
            agathaArbok.add(new Moves("Bite",Types.DARK, 60, 100, 25));
            agathaArbok.add(new Moves("Glare", Types.NORMAL, 10, 75,30)); //power 0
            agathaArbok.add(new Moves("Screech", Types.NORMAL, 10,85,40)); //power 0
            agathaArbok.add(new Moves("Acid", Types.POISON, 40, 100, 30));

            joeyRattata.add(new Moves("Tackle", Types.NORMAL, 40, 100, 35));
            joeyRattata.add(new Moves("Tail Whip", Types.NORMAL, 10, 100, 30)); //power 0
            joeyRattata.add(new Moves("Quick Attack", Types.NORMAL, 40, 100, 30));
            joeyRattata.add(new Moves("Hyper Fang", Types.NORMAL, 80, 90, 15));

//         growlithe = new Pokemon("Growlithe", Types.FIRE);
//         tentacool = new Pokemon("Tentacool", Types.WATER);
//         rowlet = new Pokemon("Rowlet", Types.GRASS);
//         gengar = new Pokemon("Gengar", Types.GHOST);
         rattata = new Pokemon("Rattata", Types.NORMAL, joeyRattata);
         arbok = new Pokemon("Arbok", Types.POISON, agathaArbok);
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
