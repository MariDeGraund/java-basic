package unitTests.fakes;

import ru.otus.game.Dice;

public class DiceSpy implements Dice {
    @Override
    public int roll() {
        return 5;
    }
}