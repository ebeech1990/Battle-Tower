import org.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        Trainers agatha = new Trainers("Agatha");
        Trainers joey = new Trainers("Joey");
//
//        Pokemon growlithe = new Pokemon("growlithe");
//        Pokemon blastoise = new Pokemon("blastoise");

//        growlithe.addMoves("incinerate", "tackle");
//        blastoise.addMoves("hydro-pump", "bite");
//
//          growlithe.getFourRandomLearnableMoves();
//          blastoise.getFourRandomLearnableMoves();

       agatha.quickSetUp(2);
       joey.quickSetUp(2);
//
//       agatha.getTeam().get(1).getMoves().forEach(m->System.out.println(m.getName()));



        Battle b = new Battle(agatha,joey);

        b.battling();


    }
}
