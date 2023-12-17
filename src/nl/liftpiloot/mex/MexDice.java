package nl.liftpiloot.mex;

public class MexDice {

    // Returns the value of the dice
    public int getDiceValue(int dice1, int dice2){
        int max = Math.max(dice1, dice2);
        int min = Math.min(dice1, dice2);
        int value = max * 10 + min;
        if (dice1 == dice2) {
            value = dice1 * 100;
        } else if (value == 21) {
            value = 1000;
        } else if (value == 31) {
            value = -1;
        }
        return value;
    }

    // Returns an array of two random dice values
    public int[] rollDice(){
        int[] dice = new int[2];
        dice[0] = (int) (Math.random() * 6) + 1;
        dice[1] = (int) (Math.random() * 6) + 1;
        return dice;
    }

}

