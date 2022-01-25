package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class GCDGame {
    public static void gcdGame() {
        var name = GreetGame.getName();
        final var diapason = 100;
        final var maxRightAnswers = 3;
        var a = Engine.newRandomNumber(diapason);
        var b = Engine.newRandomNumber(diapason);
        var rightAnswers = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Find the greatest common divisor of given numbers.");
        addInformation(a, b);
        while (scan.hasNextInt()) {
            var answer = scan.nextInt();
            var isCorrect = gcdGameLogic(a, b, name, answer);
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
            while (a == 0 || b == 0) {
                a = Engine.newRandomNumber(diapason);
                b = Engine.newRandomNumber(diapason);
            }
            addInformation(a, b);
        }

    }

    public static void addInformation(int a, int b) {
        System.out.println("Question: " + a + " " + b);
        System.out.print("Your answer: ");
    }

    public static int gcdGameLogic(int a, int b, String name, int answer) {
        var result = 0;
        if (a == b) {
            result = a;
        }
        if (a > b) {
            for (var i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    result = i;
                }
            }
        } else {
            for (var i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    result = i;
                }
            }
        }
        if (a == b && answer == result) {
            System.out.println("Correct!");
            return 1;
        }
        if (answer == result) {
            System.out.println("Correct!");
            return 1;
        } else {
            Engine.wrongPart(String.valueOf(answer), String.valueOf(result), name);
        }
        return 0;
    }
}
