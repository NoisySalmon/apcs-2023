package dice;

public class HighRoll {
    public int pOne = 0;
    public int pTwo = 0;

    public int diceRoller() {
        return (int) (Math.random() * 6 + 1);
    }

    public void highRoll() {
        int tempRollUno = (diceRoller() + diceRoller() + diceRoller());

        int tempRollDos = (diceRoller() + diceRoller() + diceRoller());

        if (tempRollUno > tempRollDos) {
            pOne += tempRollUno;
        } else if (tempRollDos > tempRollUno) {
            pTwo += tempRollDos;
        } else if (tempRollUno == tempRollDos) {
            pOne += tempRollUno;
            pTwo += tempRollUno;
        } else {
            pOne += 0;
        }

    }

    public static void main(String[] args) {
        HighRoll highRoller = new HighRoll();
        while (highRoller.pOne < 50 && highRoller.pTwo < 50) {
            highRoller.highRoll();
            if (highRoller.pOne > highRoller.pTwo) {
                System.out.println("Player One has won this round!");
            } else if (highRoller.pTwo > highRoller.pOne) {
                System.out.println("Player Two has won this round!");
            } else {
                System.out.println("Both players are tied this round!");
            }
            System.out.println("Player 1: " + highRoller.pOne + "\nPlayer 2: " + highRoller.pTwo);
        }
        if (highRoller.pOne > highRoller.pTwo) {
            System.out.println("Player One has Won the game!");
        } else {
            System.out.println("Player Two has Wonthe game!");
        }
        System.out.println("Player 1: " + highRoller.pOne + "\nPlayer 2: " + highRoller.pTwo);
    }

}
