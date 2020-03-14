import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pokemon golbat = new Pokemon("Golbat", 75, Types.POISON);
        Pokemon arbok = new Pokemon("Arbok", 80, Types.POISON);

        Pokemon rattata = new Pokemon("Rattata", 60, Types.NORMAL);
        Pokemon raticate = new Pokemon("Raticate", 80, Types.NORMAL);

        Moves bite = new Moves("Bite", Types.DARK, 60, 100, 25);
        Moves glare = new Moves("Glare", Types.NORMAL, 10, 75, 30); //power 0
        Moves screech = new Moves("Screech", Types.NORMAL, 10, 85, 40); //power 0
        Moves acid = new Moves("Acid", Types.POISON, 40, 100, 30);

        Moves tackle = new Moves("Tackle", Types.NORMAL, 40, 100, 35);
        Moves tailWhip = new Moves("Tail Whip", Types.NORMAL, 10, 100, 30); //power 0
        Moves quickAttack = new Moves("Quick Attack", Types.NORMAL, 40, 100, 30);
        Moves hyperFang = new Moves("Hyper Fang", Types.NORMAL, 80, 90, 15);

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

       List<Pokemon> agathaTeam = new ArrayList<>();
       List<Pokemon> joeyTeam = new ArrayList<>();

        agathaTeam.add(golbat);
        agathaTeam.add(arbok);

        joeyTeam.add(rattata);
        joeyTeam.add(raticate);

       Trainers agatha = new Trainers("Agatha", agathaTeam);
       Trainers youngsterJoey = new Trainers("Youngster Joey", joeyTeam);

       Battle b = new Battle(agatha,youngsterJoey);
        b.battling();
    }
}
