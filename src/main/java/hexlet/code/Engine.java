package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {

    private static void printWhenPlayerLost(String answer, String result, String name) {
        System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
        System.out.println("Let's try again, " + name + "!");
    }

    private static void printWhenCorrectAnswer() {
        System.out.println("Correct!");
    }

    private static void printWhenPlayerWin(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    private static void generateQuestion(String a) {
        System.out.println("Question: " + a);
        System.out.print("Your answer: ");
    }

    public static String getName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void runGame(Map<String, String> roundsData, String rule) {
        Scanner scanner = new Scanner(System.in);
        String name = getName(scanner);
        System.out.println(rule);
        for (Map.Entry<String, String> roundData : roundsData.entrySet()) {
            generateQuestion(roundData.getKey());
            String result = scanner.nextLine();
            String answer = roundData.getValue();
            if (result.equals(answer)) {
                printWhenCorrectAnswer();
            } else {
                printWhenPlayerLost(result, answer, name);
                scanner.close();
                return;
            }
        }
        printWhenPlayerWin(name);
        scanner.close();
    }
}
