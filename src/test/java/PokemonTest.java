import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokemonTest {
    private Trainers agatha;
    private Trainers youngsterJoey;
    private Pokemon rattata;
    private Pokemon arbok;
    private Pokemon golbat;
    private Pokemon raticate;
    private Moves bite;
    private Moves glare;
    private Moves screech;
    private Moves acid;
    private Moves tackle;
    private Moves tailWhip;
    private Moves quickAttack;
    private Moves hyperFang;
    private Battle b;

    @Before
    public void init() {
        agatha = new Trainers("Agatha");
        youngsterJoey = new Trainers("Youngster Joey");

        golbat = new Pokemon("Golbat", 75, Types.POISON);
        arbok = new Pokemon("Arbok", 80, Types.POISON);

        rattata = new Pokemon("Rattata", 60, Types.NORMAL);
        raticate = new Pokemon("Raticate", 80, Types.NORMAL);

        bite = new Moves("Bite", Types.DARK, 60, 100, 25);
        glare = new Moves("Glare", Types.NORMAL, 10, 75, 30); //power 0
        screech = new Moves("Screech", Types.NORMAL, 10, 85, 40); //power 0
        acid = new Moves("Acid", Types.POISON, 40, 100, 30);

        tackle = new Moves("Tackle", Types.NORMAL, 40, 100, 35);
        tailWhip = new Moves("Tail Whip", Types.NORMAL, 10, 100, 30); //power 0
        quickAttack = new Moves("Quick Attack", Types.NORMAL, 40, 100, 30);
        hyperFang = new Moves("Hyper Fang", Types.NORMAL, 80, 90, 15);

        golbat.addMove(bite);
        golbat.addMove(glare);
        golbat.addMove(screech);
        golbat.addMove(acid);

        arbok.addMove(bite);
        arbok.addMove(glare);
        arbok.addMove(screech);
        arbok.addMove(acid);

        rattata.addMove(tackle);
        rattata.addMove(tailWhip);
        rattata.addMove(quickAttack);
        rattata.addMove(hyperFang);

        raticate.addMove(tackle);
        raticate.addMove(tailWhip);
        raticate.addMove(quickAttack);
        raticate.addMove(hyperFang);


        agatha.addPokemon(golbat);
        agatha.addPokemon(arbok);
        golbat.setTrainer(agatha);
        arbok.setTrainer(agatha);

        youngsterJoey.addPokemon(rattata);
        youngsterJoey.addPokemon(raticate);
        rattata.setTrainer(youngsterJoey);
        raticate.setTrainer(youngsterJoey);

        b = new Battle(agatha,youngsterJoey);

    }

    @Test
    public void getTrainer() {
        String expected = "Youngster Joey";
        String actual = raticate.getTrainer().getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getHasFainted() {
        raticate.setHasFainted(true);
        Assert.assertTrue(raticate.getHasFainted());
    }


    @Test
    public void decrementHP() {
       Integer actual = arbok.decrementHP(30);
       Integer expected = 50;
       Assert.assertEquals(expected,actual);
    }

    @Test
    public void pickMove() {
        List<Moves> arbokMoves;
        arbokMoves = arbok.getMoves();
        for(Moves m : arbokMoves){
            if(m == bite){
                //m.setPp(0);
                m.setUseable(false);
            }
        }

        Moves move = arbok.pickMove();
        Assert.assertFalse(move == bite);
        Assert.assertFalse(move == bite);
        Assert.assertFalse(move == bite);
        Assert.assertFalse(move == bite);
        Assert.assertFalse(move == bite);
    }

    @Test
    public void isSuperEffective() {
        Assert.assertTrue(arbok.isSuperEffective(acid));
    }

    @Test
    public void damageToDeal() {
    }

    @Test
    public void attack() {
    }

    @Test
    public void takeDamage() {
    }
}
