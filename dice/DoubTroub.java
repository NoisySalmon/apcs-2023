package dice;

class Player {
    private int currentScore;

    public Player(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setScore(int i) {
        currentScore = i;
    }

    public int getScore() {
        return currentScore;
    }

    public void RoleDice() {
        int d1 = (int) (Math.random() * 6) + 1;
        int d2 = (int) (Math.random() * 6) + 1;

        int diceNum = d1 + d2;

        if (d1 == d2) {
            currentScore -= 5;
        } else if (diceNum == 7) {
            currentScore += 3;
        } else if (diceNum % 2 != 0) {
            currentScore++;
        }
    }

    public boolean checkIfLost() {
        if (currentScore <= 0) {
            return true;
        }
        return false;
    }
}

public class DoubTroub {
    public static void main(String[] args) {
        playFancyRound();
        // averageRounds();

    }

    public static void playFancyRound() {
        System.out.println("---------------------------------");
        System.out.println("    Welcome To Double Trouble    ");

        Player p1 = new Player(10);
        Player p2 = new Player(10);

        boolean roundInPlay = true;
        int rounds = 0;
        while (roundInPlay) {
            rounds++;
            p1.RoleDice();
            if (p1.checkIfLost())
                roundInPlay = false;
            p2.RoleDice();
            if (p2.checkIfLost())
                roundInPlay = false;

            // System.out.println("score 1: " + p1.getScore());
            // System.out.println("score 2: " + p2.getScore());
        }
        System.out.println("---------------------------------");
        System.out.println("The number of played rounds: " + rounds);
        System.out.println("Player one's score: " + p1.getScore());
        System.out.println("Player twos's score: " + p2.getScore());
        System.out.println("---------------------------------");

    }

    public static void averageRounds() {
        System.out.println("---------------------------------");
        System.out.println("    Welcome To Double Trouble    ");
        System.out.println("---------------------------------");

        Player p1 = new Player(10);
        Player p2 = new Player(10);

        double averageRoundLength = 0;
        for (int i = 0; i < 10000; i++) {
            p1.setScore(10);
            p2.setScore(10);

            boolean roundInPlay = true;
            int rounds = 0;

            while (roundInPlay) {
                rounds++;
                p1.RoleDice();
                if (p1.checkIfLost())
                    roundInPlay = false;
                p2.RoleDice();
                if (p2.checkIfLost())
                    roundInPlay = false;

                // System.out.println(p1.getScore());
                // System.out.println(p2.getScore());
            }

            averageRoundLength += rounds;
        }
        averageRoundLength /= 10000;

        System.out.println("The Average number of played rounds: " + averageRoundLength);
        System.out.println("---------------------------------");

    }
}
