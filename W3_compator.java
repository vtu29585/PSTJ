import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

        // Higher score first
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // Same score → alphabetical name
        return a.name.compareTo(b.name);
    }
}

public class Main {
    public static void main(String[] args) {

        Player[] players = {
            new Player("amy", 100),
            new Player("david", 100),
            new Player("heraldo", 50),
            new Player("aakansha", 75),
            new Player("aleksa", 150)
        };

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }
    }
}
