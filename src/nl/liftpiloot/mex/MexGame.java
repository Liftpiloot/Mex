package nl.liftpiloot.mex;

import java.util.Scanner;

public class MexGame {
    int players;
    int rollCount;
    public MexGame(String[] names) {
        players = names.length;
        rollCount = 3;
    }
    public int round() {
        System.out.println("You can roll " + rollCount + " time" + (rollCount == 1 ? "." : "s."));
        int value = 0;
        for (int i = 0; i < rollCount; i++) {
            Scanner scanner = new Scanner(System.in);
            MexDice dice = new MexDice();
            int[] diceValues = dice.rollDice();
            value = dice.getDiceValue(diceValues[0], diceValues[1]);
            System.out.println(value);
            System.out.println("Roll again? (y/n)");
            String input = scanner.nextLine();
            if (input.equals("n")) {
                break;
            }
        }
        return value;
    }
}
