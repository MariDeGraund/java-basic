package unitTests;

import ru.otus.game.DiceImpl;


public class DiceImplTest {
    private DiceImpl dice = new DiceImpl();
    private int diceRoll;
    public void testDiceAvailableValuesNotNegative() {
        final String scenario = "Тест на значение игральной кости - не отрицательно";
        try {
            for (int i = 0; i < 100; i++) {
                diceRoll = dice.roll();
                if (diceRoll < 0) {
                    throw new RuntimeException("Значение игральной кости не может быть отрицательным (" +
                            (i + 1) + " бросок: " + diceRoll + ")");
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceAvailableValuesNotZero() {
        final String scenario = "Тест значения игральной кости не равно нулю";
        try {
            for (int i = 0; i < 100; i++) {
                diceRoll = dice.roll();
                if (diceRoll == 0) {
                    throw new RuntimeException("Значение игральной кости не может быть нулевым (" +
                            (i + 1) + " бросок: " + diceRoll + ")");
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceAvailableValuesNotBig() {
        final String scenario = "Тест значения игральной кости не больше 6";
        try {
            for (int i = 0; i < 100; i++) {
                diceRoll = dice.roll();
                if (diceRoll > 6) {
                    throw new RuntimeException("Значение игральной кости не может быть больше 6 (" +
                            (i + 1) + " бросок: " + diceRoll + ")");
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}