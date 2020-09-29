package dice;

import java.util.Random;

public class EvenBiasedDice implements Dice {
    private final int numFaces;

    public EvenBiasedDice(int numFaces) {
        this.numFaces = numFaces;
    }

    public int roll() {
        Random random = new Random();

        int res = random.nextInt(numFaces+1 - 1) + 1;

        while (res % 2 == 1) {
            res = random.nextInt(numFaces+1 - 1) + 1;
        }

        return res;
    }
}
