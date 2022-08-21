package unitTests;

import unitTests.fakes.*;
import ru.otus.game.*;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;

public class GameTest {
    public void equalsFlows(List<String> unExpectedFlow, List<String> actualFlow){
            for (int i = 0; i < unExpectedFlow.size(); i++) {
                if (unExpectedFlow.equals(actualFlow)) {
                    throw new AssertionError(String.format("Победителем не может быть \"%s\", т.к. ничья",
                            unExpectedFlow));
                }
            }
    }
    public void testGameDeadHeat() {
        String scenario = "Тест на ничью";

        Player player1 = new Player("Влад");
        Player player2 = new Player("Ира");
        List<String> winPlayer1Flow = List.of("Победитель: " + player1.getName());
        List<String> winPlayer2Flow = List.of("Победитель: " + player2.getName());
        List<String> actualFlow = new ArrayList<>();

        try {
            Dice diceSpy = new DiceSpy();
            GameWinnerConsolePrinterSpy win = new GameWinnerConsolePrinterSpy(actualFlow);
            Game game = new Game(diceSpy, win);
            game.playGame(player1, player2);

            equalsFlows(winPlayer1Flow, actualFlow);

            equalsFlows(winPlayer2Flow, actualFlow);

            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}