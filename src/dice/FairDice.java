package dice;

import java.util.Random;

public class FairDice implements Dice {
    private final int numFaces;

    public FairDice(int numFaces) {
        this.numFaces = numFaces;
    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(numFaces+1 - 1) + 1;
    }
}
