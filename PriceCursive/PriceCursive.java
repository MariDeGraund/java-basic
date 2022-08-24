package PriceCursive;

import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;
import java.util.Scanner;

class Currency {
    static String[] currency = {"рубль", "рубля", "рублей"};

    public String getCurrency(int i) {
        return currency[i];
    }

}

public class PriceCursive {
    private final BigDecimal amount;

    public PriceCursive(String s) {
        amount = new BigDecimal(s);
    }

    static int getMod(String numStr) {
        //String numStr = String.valueOf(num);
        int numLength = numStr.length();
        int num1 = Integer.parseInt(numStr.substring(numLength - 1));
        int num2 = Integer.parseInt(numStr.substring((numLength - 2), (numLength - 1)));

        if (num2 == 1) {
            return 2;
        } else {
            return switch (num1) {
                case 1 -> 0;
                case 2, 3, 4 -> 1;
                default -> 2;
            };
        }
    }

    //Выводим число прописью
    public String numToCursive() {
        String[][] ten1 = {{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};

        String[] ten2 = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        String[] tens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

        String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

        String[][] extent = {{"", "", "", "0"},
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард", "миллиарда", "миллиардов", "0"},
                {"триллион", "триллиона", "триллионов", "0"}};

        long price = amount.longValue();
        long price_tmp = price;

        // Разбить на сегменты по 3
        ArrayList <Long> segments = new ArrayList<>();
        while (price_tmp > 999) {
            long seg = price_tmp / 1000;
            segments.add(price_tmp - (seg * 1000));
            price_tmp = seg;
        }
        segments.add(price_tmp);
        Collections.reverse(segments);

        // Анализ сегментов
        String strResult = "";
        int lev = segments.size();

        // перебираем сегменты
        for (int i = 0, j = segments.size(); i < segments.size(); i++, j--) {
            if (price == 0) {
                strResult = "ноль";
                break;
            }
            // текущий сегмент
            int ri = (int) Integer.parseInt(segments.get(i).toString());
            // если сегмент ==0 И не последний уровень
            if (ri == 0 && lev > 1) {
                lev--;
                continue;
            }
            String rs = String.valueOf(ri);

            // если длина меньше 3, добавим 0, чтоб проще было
            if (rs.length() == 1) rs = "00" + rs;
            if (rs.length() == 2) rs = "0" + rs;

            // Разбор по цифрам
            int n1 = (int) Integer.parseInt(rs.substring(0, 1)); //первая цифра
            int n2 = (int) Integer.parseInt(rs.substring(1, 2)); //вторая
            int n3 = (int) Integer.parseInt(rs.substring(2, 3)); //третья

            // Анализируем
            String nr1 = hundreds[n1]; //первая цифра
            String nr2;
            String nr3;

            if (n2 == 1) {
                nr2 = ten2[n3];
                nr3 = "";
            } else {
                nr2 = tens[n2];
                nr3 = ten1[Integer.parseInt(extent[j - 1][3])][n3];
            }//вторая //третья

            strResult = strResult + " " + nr1 + " " + nr2 + " " + nr3 + " " + extent[j - 1][getMod(rs)];
            strResult = strResult.trim().replaceAll(" +", " ");
            lev--;
        }
        // Добавить валюту
        String resultMod = String.valueOf(price);

        // если длина меньше 3, добавим 0, чтоб проще было
        if (resultMod.length() == 1) resultMod = "00" + resultMod;
        if (resultMod.length() == 2) resultMod = "0" + resultMod;

        int resMod = getMod(resultMod);

        Currency currency = new Currency();
        return strResult + " " + currency.getCurrency(resMod);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        String a = scanner.next();
        PriceCursive price = new PriceCursive(a);
        System.out.print(price.numToCursive());
    }
}
