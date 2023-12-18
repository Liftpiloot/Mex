package nl.liftpiloot.mex;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[] names = {"Piet", "Klaas", "Henk"};
        MexGame game = new MexGame(names);
        game.StartGame();
    }
}
