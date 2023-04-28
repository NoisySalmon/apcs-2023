package unit11;

import java.util.ArrayList;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void recordSlams(int slams) {
        if (slams == 1 && score < 15)
            score++;
        else if (slams == 2 && score + 5 <= 15)
            score += 5;
        else if (slams == 3)
            score = 15;
    }
}

public class Slam {

    private ArrayList<Player> players = new ArrayList<Player>();
    private int slam;
    private int round;

    private int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public Slam(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + i));
        }
        slam = roll();
        round = 0;
    }

    private void playRound() {
        round++;
        // System.out.println("Round " + round);
        for (Player player : players) {
            int slams = 0;
            for (int i = 0; i < 3; i++) {
                int roll = roll();
                if (roll == slam) {
                    slams++;
                }
            }
            if (slams > 2)
                System.out.println(player.getName() + " grand slammed in round " + round + "!");

            player.recordSlams(slams);
        }
        ArrayList<Player> out = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getScore() == 15) {
                // System.out.println(player.getName() + " is out!");
                out.add(player);
            }
        }
        for (Player player : out) {
            players.remove(player);
        }
    }

    public void playGame() {
        while (players.size() > 1) {
            playRound();
        }
        if (players.size() > 0)
            System.out.println(players.get(0).getName() + " wins!");
        System.out.println("It took " + round + " rounds.");
    }

    public static void main(String[] args) {
        Slam slam = new Slam(3);
        slam.playGame();
    }

}