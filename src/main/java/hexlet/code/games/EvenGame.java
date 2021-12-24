package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    public static void isNumberEvenOrNot() {
        var name = GreetGame.getName();
        var rightAnswers = 0;
        final var diapason = 100; // Диапазон чисел для задачи от 1 до 99
        final var maxRightAnswers = 3;
        var isCorrect = 0;
        var a = Engine.newRandomNumber(diapason);
        Scanner scan = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        addInformation(a);
        while (scan.hasNextLine()) {
            var answer = scan.nextLine();
            if (answer.equals(YES) || answer.equals(NO)) {
                boolean even = a % 2 == 0;
                if (answer.equals(YES)) {
                    isCorrect = evenGameLogic(even, answer, name);
                }
                if (answer.equals(NO)) {
                    isCorrect = evenGameLogic(!even, answer, name);
                }
            } else {
                System.out.println(answer + " is wrong answer. Please answer correctly 'yes' or 'no'");
                return;
            }
            if (isCorrect == 0) {
                return;
            } else {
                rightAnswers++;
            }
            if (rightAnswers == maxRightAnswers) {
                Engine.congratsPart(rightAnswers, maxRightAnswers, name);
                return;
            }
            a = Engine.newRandomNumber(diapason);
            addInformation(a);
        }
    }

    private static void addInformation(double a) {
        System.out.println("Question: " + (int) a);
        System.out.print("Your answer: ");
    }

    public static int evenGameLogic(boolean isEven, String answer, String name) {
        if (isEven) {
            System.out.println("Correct!");
        } else {
            Engine.wrongPart(answer, NO, name);
            return 0;
        }
        return 1;
    }
}

