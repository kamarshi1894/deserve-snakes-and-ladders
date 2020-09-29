package dice;

import java.util.Random;

public class FairDice implements Dice {
    private final int numFaces;
    private final Random random = new Random();

    public FairDice(int numFaces) {
        this.numFaces = numFaces;
    }

    public int roll() {
        return random.nextInt(numFaces) + 1;
    }
}
