package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    public static void progressionGame() {
        var name = GreetGame.getName();
        final var minProgressionLength = 5;
        final var maxRightAnswers = 3;
        var progressionLength = Engine.newRandomNumber(minProgressionLength) + minProgressionLength;
        var step = Engine.newRandomNumber(minProgressionLength);
        var progressionStartNumber = Engine.newRandomNumber(minProgressionLength);
        var missingElement = Engine.newRandomNumber(progressionLength - 2) + 1;
        var rightAnswers = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");
        var missingResult = addInformation(step, progressionStartNumber, missingElement, progressionLength);
        while (scan.hasNextInt()) {
            var answer = scan.nextInt();
            var isCorrect = progressionGameLogic(missingResult, answer, name);
            if (isCorrect == 0) {
                return;
            } else {
                rightAnswers++;
            }
            if (rightAnswers == maxRightAnswers) {
                Engine.congratsPart(name);
                return;
            }
            progressionLength = Engine.newRandomNumber(minProgressionLength) + minProgressionLength;
            step = Engine.newRandomNumber(minProgressionLength);
            progressionStartNumber = Engine.newRandomNumber(minProgressionLength);
            missingElement = Engine.newRandomNumber(progressionLength - 2) + 1;
            missingResult = addInformation(step, progressionStartNumber, missingElement, progressionLength);
        }
    }

    public static int addInformation(int progressionStep, int progressionStartNumber, int progressionMissingElement,
                                      int progressionLength) {
        System.out.print("Question: ");
        System.out.print(progressionStartNumber + " ");
        var result = progressionStartNumber;
        var missingResult = 0;
        for (var i = 1; i < progressionLength; i++) {
            result = result + progressionStep;
            if (i == progressionMissingElement) {
                missingResult = result;
                System.out.print(".." + " ");
            } else {
                System.out.print(result + " ");
            }
        }
        System.out.println();
        System.out.print("Your answer: ");
        return missingResult;
    }

    public static int progressionGameLogic(int missingResult, int answer, String name) {
        if (answer == missingResult) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println(answer + " is wrong answer ;(. Correct answer was " + missingResult + ".");
            System.out.println("Let's try again, " + name);
        }
        return 0;
    }
}
