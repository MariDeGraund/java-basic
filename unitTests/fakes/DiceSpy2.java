package unitTests.fakes;

import ru.otus.game.Dice;

public class DiceSpy2 implements Dice {
    static int rollMax;

    public int roll() {
        int valueDice;
        if (this.rollMax == 6) {
            valueDice = 5;
        } else {
            valueDice = 6;
            this.rollMax = 6;
        }
        return valueDice;
    }
}