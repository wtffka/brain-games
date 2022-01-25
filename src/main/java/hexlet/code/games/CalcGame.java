package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {

    public static void randomCalcOperation() {
        var name = GreetGame.getName();
        final var diapason = 10; // Диапазон чисел для математических операций в этой игре.
        final var maxRightAnswers = 3;
        final var operationsQuantity = 3;
        var randomOperation = Engine.newRandomNumber(operationsQuantity);
        var a = Engine.newRandomNumber(diapason);
        var b = Engine.newRandomNumber(diapason);
        var rightAnswers = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        addInformation(a, randomOperation, b);
        while (scan.hasNextInt()) {
            var isCorrect = 0;
            var answer = scan.nextInt();
            isCorrect = Engine.calcGameLogic(answer, a, b, randomOperation, name);
            if (isCorrect == 0) {
                return;
            } else {
                rightAnswers++;
            }
            if (rightAnswers == maxRightAnswers) {
                Engine.congratsPart(name);
                return;
            }

            a = Engine.newRandomNumber(diapason);
            b = Engine.newRandomNumber(diapason);
            randomOperation = Engine.newRandomNumber(operationsQuantity);
            addInformation(a, randomOperation, b);
        }
    }

    private static void addInformation(int a, int b, int c) {
        var operation = "+";
        if (b == 0) {
            operation = "+";
        } else if (b == 1) {
            operation = "*";
        } else if (b == 2) {
            operation = "-";
        }
        System.out.println("Question: " + a + " " + operation + " " + c);
        System.out.print("Your answer: ");
    }

}
