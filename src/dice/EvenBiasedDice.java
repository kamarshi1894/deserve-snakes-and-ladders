package dice;

import java.util.Random;

public class EvenBiasedDice implements Dice {
    private final int numFaces;
    private final Random random = new Random();

    public EvenBiasedDice(int numFaces) {
        this.numFaces = numFaces;
    }

    public int roll() {
        int res = random.nextInt(numFaces) + 1;

        while (res % 2 == 1) {
            res = random.nextInt(numFaces) + 1;
        }

        return res;
    }
}
