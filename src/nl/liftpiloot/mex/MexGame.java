package nl.liftpiloot.mex;

import java.util.Scanner;

public class MexGame {
    private String[] players;
    private Boolean isBluff = false;
    private int previousValue;
    private int rollCount;

    public MexGame(String[] names) {
        players = names;
        rollCount = 3;
    }

    public int round(Boolean firstRound) {
        System.out.println("You can roll " + rollCount + " time" + (rollCount == 1 ? "." : "s."));
        int value = 0;
        for (int i = 0; i < rollCount; i++) {
            Scanner scanner = new Scanner(System.in);
            MexDice dice = new MexDice();
            // ask user to roll the dice
            System.out.println("Press enter to roll the dice");
            scanner.nextLine();
            int[] diceValues = dice.rollDice();
            value = dice.getDiceValue(diceValues[0], diceValues[1]);
            System.out.println("Your value is:" + value);
            // ask to roll again if rollcount is not reached
            String input = "";
            if (i < rollCount - 1) {
                System.out.println("Do you want to roll again? (y/n)");
                input = scanner.nextLine();
            } else {
                input = "n";
            }
            if (input.equals("n")) {
                if (firstRound) {
                    rollCount = i + 1;
                }
                break;
            }
        }
        return value;
    }

    public void StartGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < players.length; i++) {
                System.out.println("It's " + players[i] + "'s turn");
                int value = 0;
                if (previousValue == 0) {
                    System.out.println("Welcome to Mex!");
                    value = this.round(true);
                } else {
                    // ask the user if he wants to call a bluff
                    System.out.println("Do you want to call a bluff? (y/n)");
                    String input = scanner.next();
                    scanner.nextLine();
                    if (input.equals("y")) {
                        if (isBluff) {
                            System.out.println("You were right!");
                            i--;
                            previousValue = 0;
                            rollCount = 3;
                            isBluff = false;
                            break;
                        } else {
                            System.out.println("You were wrong!");
                            break;
                        }
                    }
                    isBluff = false;
                    value = this.round(false);
                    if (value <= previousValue) {
                        System.out.println("Too low");
                        // ask the user if they want to bluff
                        System.out.println("Enter a number to bluff");
                        int bluff = scanner.nextInt();
                        isBluff = true;
                        value = bluff;
                    }
                }
                previousValue = value;
            }
        }
    }
}
