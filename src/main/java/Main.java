import org.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        Trainers agatha = new Trainers("Agatha");
        Trainers joey = new Trainers("Joey");

        Pokemon growlithe = new Pokemon("growlithe");
        Pokemon blastoise = new Pokemon("blastoise");

        growlithe.addMoves("incinerate", "tackle");
        blastoise.addMoves("hydro-pump", "bite");

        agatha.addPokemon(growlithe);
        joey.addPokemon(blastoise);

        Battle b = new Battle(agatha,joey);

        b.battling();

    }
}
