package dice;

/* Dice game name: MEXICO
 * Each player starts the game with 6 lives. In the first round, all players take their turn 
 * and roll the 2 dice. Each player’s score in that round is simply the sum of both dice. The 
 * player with the lowest roll in that turn loses a life and has to change his personal dice 
 * accordingly (from 6 to 5 in the first round). The game is continued and each round a player 
 * loses a life. When a player has lost all his or her lives, that player no longer 
 * participates in the game. The game ends when there is only one player left and all other 
 * players have lost all of their lives.
*/
public class Mexico {

    private int sOne;
    private int sTwo;
    private int rOne;
    private int rTwo;
    private String win;

    public Mexico() {
        sOne = 6;
        sTwo = 6;
        int numrounds = 0;
        while ((sOne != 0) && (sTwo != 0)) {
            playRound();
            numrounds++;
        }
        if (sOne == 0) {
            win = "TWO";
        } else {
            win = "ONE";
        }
        System.out.println("After " + numrounds + " rounds, PLAYER " + win + " wins!");
    }

    public static int roll() {
        int roll = (int) (Math.random() * 6 + 1);
        return roll;
    }

    public void playRound() {
        rOne = roll();
        rTwo = roll();
        if (rOne > rTwo) {
            sTwo--;
        } else {
            sOne--;
        }
    }

    public static void intro() {
        System.out.println("Welcome to the dice game MEXICO!");
    }

    public static void main(String[] args) {
        intro();
        Mexico game = new Mexico();

    }
}
