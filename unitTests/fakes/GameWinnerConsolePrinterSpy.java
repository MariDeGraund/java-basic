package unitTests.fakes;

import ru.otus.game.*;
import java.util.List;

public class GameWinnerConsolePrinterSpy implements GameWinnerPrinter {
    public static List<String> actualFlow;

    public GameWinnerConsolePrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }
    @Override
    public void printWinner(Player winner) {
        actualFlow.add("Победитель: " + winner.getName());
    }
}