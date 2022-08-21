import java.util.Scanner;

class Calculator {
    double num1;
    double num2;
    double ans;
    char op;

    void ExecuteOperation(double num1, double num2, char op) throws Exception {
        switch (op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                throw new Exception("Недопустимая операция!");
        }
    }

    void ScanNum() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите 1-ое значения: ");
            num1 = scanner.nextDouble();
            System.out.print("Введите 2-ое значения: ");
            num2 = scanner.nextDouble();
        } catch (Exception e) {
            System.out.print("Введено некорректное значение");
            throw e;
        }
    }

    void ScanOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите требуемую операцию (+, -, *, /): ");
        op = scanner.next().charAt(0);
    }

    void PrintResult() {
        System.out.print("\nРезультат выполнения операции:\n");
        System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
    }
}

class UserCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Считывание значений
            calc.ScanNum();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.print("\nНеобходимо ввести число для произведения операции");
            System.exit(53);
        }
        try {
            // Считывание операции
            calc.ScanOperation();
        }
        catch (Exception e) {
            //Попробуем повторить
            System.out.print("\nВведенная операция не соответствует допустимым значениям\nВведите операцию из предложенного списка(+, -, *, /): ");
            calc.ScanOperation();
        }
        try {
            // Выполнение операции
            calc.ExecuteOperation(calc.num1, calc.num2, calc.op);
        } catch (Exception e) {
            System.out.print("\nВведенная операция не соответствует допустимым значениям");
            // Попытка считать и обработать новую операцию
            calc.ScanOperation();
            try {
                calc.ExecuteOperation(calc.num1, calc.num2, calc.op);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        // Вывод результата
        calc.PrintResult();
    }
}