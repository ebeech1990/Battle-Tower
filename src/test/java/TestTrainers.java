import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTrainers {
    private Trainers agatha;
    private Trainers youngsterJoey;
    private Pokemon rattata;
    private Pokemon arbok;
    private Pokemon golbat;
    private Pokemon raticate;
    private List<Moves> agathaArbok;
    private List<Moves> joeyRattata;
    private List<Pokemon> agathaTeam;
    private List<Pokemon> joeyTeam;

    @Before
    public void init() {
        agathaArbok = new ArrayList<>();
        joeyRattata = new ArrayList<>();

        agathaArbok.add(new Moves("Bite", Types.DARK, 60, 100, 25));
        agathaArbok.add(new Moves("Glare", Types.NORMAL, 10, 75, 30)); //power 0
        agathaArbok.add(new Moves("Screech", Types.NORMAL, 10, 85, 40)); //power 0
        agathaArbok.add(new Moves("Acid", Types.POISON, 40, 100, 30));

        joeyRattata.add(new Moves("Tackle", Types.NORMAL, 40, 100, 35));
        joeyRattata.add(new Moves("Tail Whip", Types.NORMAL, 10, 100, 30)); //power 0
        joeyRattata.add(new Moves("Quick Attack", Types.NORMAL, 40, 100, 30));
        joeyRattata.add(new Moves("Hyper Fang", Types.NORMAL, 80, 90, 15));

        golbat = new Pokemon("Golbat", 75, Types.POISON);
        arbok = new Pokemon("Arbok", 80, Types.POISON);

        rattata = new Pokemon("Rattata", 60, Types.NORMAL);
        raticate = new Pokemon("Raticate", 80, Types.NORMAL);

        agathaTeam = new ArrayList<>();
        joeyTeam = new ArrayList<>();

        agathaTeam.add(golbat);
        agathaTeam.add(arbok);

        joeyTeam.add(rattata);
        joeyTeam.add(raticate);

        agatha = new Trainers("Agatha", agathaTeam);
        youngsterJoey = new Trainers("Youngster Joey", joeyTeam);

    }

    @Test
    public void numOfPokemonTest() {
        Assert.assertTrue(agatha.getTeam().size() == 2);
    }

    @Test
    public void battle(){
        Battle b = new Battle(youngsterJoey,agatha);

    }
}


