package UnitTest;

import PriceCursive.PriceCursive;
import java.util.Objects;
import static java.lang.System.out;

public class PriceCursiveTest {

    public void priceCursiveTestFormat() {
        String scenario = "Тест форматирование числа в строку";
        String[][] numList = {{"123", "сто двадцать три рубля"},
                              {"458618", "четыреста пятьдесят восемь тысяч шестьсот восемнадцать рублей"}};

        try {
            for (int i = 0; i < numList.length; i++) {
                String a = numList[i][0];
                PriceCursive price = new PriceCursive(a);
                String strResult = price.numToCursive();
                String b = numList[i][1];
                checkResult(b, strResult);

            }
            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

     public static void checkResult(String str, String strResult) {
        if (!Objects.equals(str, strResult)) {
            throw new AssertionError(String.format("Ожидалась строка \"%s\", а получили \"%s\"",
                    strResult, str));
        }
    }

    public void priceCursiveTestFormatNum() {
        String scenario = "Тест отрицательное число";
        try {
                String a = "-45";
                String str = "минус сорок пять рублей";

                PriceCursive price = new PriceCursive(a);
                String strResult = price.numToCursive();
                checkResult(str, strResult);

            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void priceCursiveTestNull() {
        String scenario = "Тест на NULL";
        try {
            String a = null;
            String str = "";

            PriceCursive price = new PriceCursive(a);
            String strResult = price.numToCursive();
            checkResult(str, strResult);

            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void priceCursiveTest0() {
        String scenario = "Тест на 0";
        try {
            String a = "0";
            String str = "ноль рублей";

            PriceCursive price = new PriceCursive(a);
            String strResult = price.numToCursive();
            checkResult(str, strResult);

            out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
