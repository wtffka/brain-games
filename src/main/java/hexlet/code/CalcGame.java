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
            var answer = scan.nextInt();
            if (randomOperation == 0) {
                if (a + b == answer) {
                    System.out.println("Correct!");
                    rightAnswers++;
                } else {
                    System.out.println(answer + " is wrong answer ;(. Correct answer was " + (a + b) + ".");
                    System.out.println("Let's try again, " + name);
                    rightAnswers = 0;
                    return;
                }
                a = (int) (Math.random() * diapason);
                b = (int) (Math.random() * diapason);
            }
            if (randomOperation == 1) {
                if (a * b == answer) {
                    System.out.println("Correct!");
                    rightAnswers++;
                } else {
                    System.out.println(answer + " is wrong answer ;(. Correct answer was " + (a * b) + ".");
                    System.out.println("Let's try again, " + name);
                    return;
                }
                a = (int) (Math.random() * diapason);
                b = (int) (Math.random() * diapason);
            }
            if (randomOperation == 2) {
                if (a - b == answer) {
                    System.out.println("Correct!");
                    rightAnswers++;
                } else {
                    System.out.println(answer + " is wrong answer ;(. Correct answer was " + (a - b) + ".");
                    System.out.println("Let's try again, " + name);
                    return;
                }
                a = (int) (Math.random() * diapason);
                b = (int) (Math.random() * diapason);
            }
            if (rightAnswers == maxRightAnswers) {
                System.out.println("Congratulations, " + name + "!");
                return;
            }
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

//    private static int newOperations(double a, double b, double c) {
//        var diapason = 100;
//        a = (int) (Math.random() * diapason);
//        b = (int) (Math.random() * 3);
//        c = (int) (Math.random() * diapason);
//        return a, b, c;
//    }
}
