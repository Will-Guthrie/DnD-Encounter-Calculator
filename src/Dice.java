import java.util.Random;

public class Dice {

    private int numSides;
    private Random rand = new Random();

    Dice (int numSides) {
        this.numSides = numSides;
    }

    public int roll() {
        return rand.nextInt(numSides) + 1;
    }
}
