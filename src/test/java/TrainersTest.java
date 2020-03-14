import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TrainersTest {
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
    public void getTeam() {
        String expected = "Golbat\nArbok\n";

       String actual = agatha.getTeam()
               .stream()
               .map(p -> p.getName()+"\n")
               .reduce("", String::concat);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getBattlingPokemon() {
        golbat.setHp(0);
        String expected = "Arbok";
        String actual = agatha.getBattlingPokemon().getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void outOfPokemon() {
        golbat.setHp(0);
        arbok.setHp(0);
        Assert.assertTrue(agatha.outOfPokemon());
    }
}
