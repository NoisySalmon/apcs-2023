package dice;

public class DoubleTrouble {

    private int player1;
    private int player2;
    private int rolla1;
    private int rolla2;
    private int rollb1;
    private int rollb2;

    public DoubleTrouble(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public DoubleTrouble() {
        player1 = 10;
        player2 = 10;
    }

    public void evenOrOdd() {
        if (rolla1 + rolla2 % 2 == 1) {
            player1 += 1;
        }
        if (rollb1 + rollb2 % 2 == 1) {
            player2 += 1;
        }
    }

    public void sevenOrDouble() {
        if (rolla1 + rolla2 == 7) {
            player1 += 3;
        }
        if (rolla1 == rolla2) {
            player1 -= 5;
        }
        if (rollb1 + rollb2 == 7) {
            player2 += 3;
        }
        if (rollb1 == rollb2) {
            player2 -= 5;
        }
    }

    public void rollDice() {
        rolla1 = (int) ((Math.random() * 6) + 1);
        rolla2 = (int) ((Math.random() * 6) + 1);
        rollb1 = (int) ((Math.random() * 6) + 1);
        rollb2 = (int) ((Math.random() * 6) + 1);
        System.out.println("Player1 rolled " + rolla1 + " and " + rolla2);
        System.out.println("Player2 rolled " + rollb1 + " and " + rollb2);
    }

    public static int playGame() {
        DoubleTrouble play = new DoubleTrouble();
        int count = 0;
        while (play.player1 > 0 && play.player2 > 0) {
            count++;
            play.rollDice();
            play.evenOrOdd();
            play.sevenOrDouble();
            System.out.println("--");
            System.out.println("Player1:" + play.player1);
            System.out.println("Player2:" + play.player2);
        }
        System.out.println("Game Over: " + count + " rounds played.");
        return count;
    }

    public static void main(String[] args) {
        int roundsToPlay = 1000;
        int totalRound = 0;
        for (int i = 0; i < roundsToPlay; i++) {
            totalRound += playGame();
        }
        System.out.println("Average rounds played: " + totalRound / roundsToPlay);

    }

}