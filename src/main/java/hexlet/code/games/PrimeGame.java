package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    public static void primeGame() {
        var name = GreetGame.getName();
        final var diapason = 50;
        final var maxRightAnswers = 3;
        var a = Engine.newRandomNumber(diapason);
        var rightAnswers = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        addInformation(a);
        while (scan.hasNextLine()) {
            var answer = scan.nextLine();
            var isCorrect = 0;
            if (answer.equals(YES) || answer.equals(NO)) {
                var divisors = divisors(a);
                boolean isPrime = divisors == 0;
                if (answer.equals(YES)) {
                    isCorrect = primeGameLogic(a, isPrime, answer, name);
                }
                if (answer.equals(NO)) {
                    isCorrect = primeGameLogic(a, !isPrime, answer, name);
                }
            }
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
            addInformation(a);
        }
    }

    public static void addInformation(int a) {
        System.out.println("Question: " + a);
        System.out.print("Your answer: ");
    }

    public static int primeGameLogic(int a, boolean isPrime, String answer, String name) {
        if (isPrime) {
            System.out.println("Correct!");
            return 1;
        } else {
            if (answer.equals(YES)) {
                Engine.wrongPart(answer, NO, name);
            } else {
                Engine.wrongPart(answer, YES, name);
            }
        }
        return 0;
    }

    public static int divisors(int a) {
        var divisors = 0;
        for (var i = 2; i < a; i++) {
            if (a % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }
}

