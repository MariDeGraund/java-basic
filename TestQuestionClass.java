import java.util.Scanner;

class Question {
    public static String[][] question;

    Question(String[][] listQuestion) {
        question = listQuestion;
    }

    public static void printQuestion(int questionNumber) {
        System.out.println("Вопрос №" + (questionNumber + 1) + " " + question[questionNumber][0]);
        printAnswer(questionNumber);
    }

    public static void printAnswer(int questionNumber) {
        for (int i = 2, j = 1; i < question[questionNumber].length; i++, j++) {
            System.out.println("   " + j + ". " + question[questionNumber][i]);
        }
    }
}

class ResultQuestion {
    int rightAnswer;
    int errorAnswer;

    public void printResultTest() {
        System.out.println("Результат: правильно " + rightAnswer + ", неправильно " + errorAnswer);
    }

    public void saveRightAnswer() {
        rightAnswer = rightAnswer + 1;
    }

    public void saveErrorAnswer() {
        errorAnswer = errorAnswer + 1;
    }
}

public class TestQuestionClass {
    public static void main(String[] args) {
        final int COUNT_QUESTION = 3;
        // Массив с вопросами и ответами
        enum Ansver {Правильно, Неправильно}
        ;
        String[][] question = {
                {"Скажите, что получится, если смешать корень златоцветника и настойку полыни?", "2", "Ничего", "Снотворное зелье такой силы, что его называют «Напиток живой смерти»", "Яд"},
                {"Скажите, где вы будете искать безоаровый камень?", "1", "В желудке козы", "В горных пещерах", "На дне озера", "На вершине горы"},
                {"В чем разница между Аконитом и Борецем?", "2", "Аконит красного цвета, а Бореций - синий", "Это одно и то же растение", "Бореций это трава, а Аконит - камень", "Аконит можно найти в горах, а Бореций в подземельях", "Бореция не существует"}
        };

        Question testQuestion = new Question(question);
        ResultQuestion resultQuestion = new ResultQuestion();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < testQuestion.question.length; i++) {
            Question.printQuestion(i);
            int a = scanner.nextInt();
            if (a == Integer.parseInt(testQuestion.question[i][1])) {
                System.out.println(Ansver.Правильно);
                resultQuestion.saveRightAnswer();
            } else {
                System.out.println(Ansver.Неправильно);
                resultQuestion.saveErrorAnswer();
            }
        }
        resultQuestion.printResultTest();
    }
}