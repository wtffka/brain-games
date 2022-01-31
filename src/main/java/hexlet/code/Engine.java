package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    private static Scanner s = new Scanner(System.in);

    private static void youLose(String answer, String result, String name) {
        System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
        System.out.println("Let's try again, " + name + "!");
    }

    private static void guessedRight() {
        System.out.println("Correct!");
    }

    private static void youWon(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    private static void generateQuestion(String a) {
        System.out.println("Question: " + a);
        System.out.print("Your answer: ");
    }

    public static String getName() {
        System.out.println("Welcome to the Brain Games");
        System.out.print("May I have your name? ");
        String name = s.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void runGame(Map<String, String> map, String name, String rule) {
        System.out.println(rule);
        for (Map.Entry<String, String> m : map.entrySet()) {
            generateQuestion(m.getKey());
            String result = s.nextLine();
            String answer = m.getValue();
            if (result.equals(answer)) {
                guessedRight();
            } else {
                youLose(result, answer, name);
                s.close();
                return;
            }
        }
        youWon(name);
        s.close();
    }
}
