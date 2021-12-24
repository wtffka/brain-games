package hexlet.code;
import java.util.Scanner;

public class CalcGame {

    public static void randomCalcOperation() {
        var name = Cli.getName();
        final var diapason = 10; // Диапазон чисел для математических операций в этой игре.
        final var maxRightAnswers = 3;
        final var operationsQuantity = 3;
        var randomOperation = (int) (Math.random() * operationsQuantity);
        var a = (int) (Math.random() * diapason);
        var b = (int) (Math.random() * diapason);
        var rightAnswers = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        addInformation(a, randomOperation, b);
        while (scan.hasNextInt()) {
            var isCorrect = 0;
            var answer = scan.nextInt();
            if (randomOperation == 0) {
                isCorrect = gameLogic(answer, a, b, randomOperation, name);
            }
            if (randomOperation == 1) {
                isCorrect = gameLogic(answer, a, b, randomOperation, name);
            }
            if (randomOperation == 2) {
                isCorrect = gameLogic(answer, a, b, randomOperation, name);
            }
            if (isCorrect == 0) {
                return;
            } else if (isCorrect == 1) {
                rightAnswers++;
            }
            if (rightAnswers == maxRightAnswers) {
                System.out.println("Congratulations, " + name + "!");
                return;
            }
            a = (int) (Math.random() * diapason);
            b = (int) (Math.random() * diapason);
            randomOperation = (int) (Math.random() * operationsQuantity);
            addInformation(a, randomOperation, b);
        }
    }

    private static void addInformation(double a, double b, double c) {
        var operation = "";
        if (b == 0) {
            operation = "+";
        } else if (b == 1) {
            operation = "*";
        } else if (b == 2) {
            operation = "-";
        }
        System.out.println("Question: " + (int) a + " " + operation + " " + (int) c);
        System.out.print("Your answer: ");
    }

    public static int gameLogic(int answer, int a, int b, int operation, String name) {
        var result = 0;
        if (operation == 0) {
            result = a + b;
        } else if (operation == 1) {
            result = a * b;
        } else if (operation == 2) {
            result = a - b;
        }
        if (result == answer) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
            System.out.println("Let's try again, " + name);
            return 0;
        }
    }
}
