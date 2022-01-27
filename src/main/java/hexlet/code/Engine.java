package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {

    public static void wrongPart(String answer, String result, String name) {
        System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
        System.out.println("Let's try again, " + name + "!");
    }

    public static void correctPart() {
        System.out.println("Correct!");
    }

    public static void congratsPart(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static void question(String a) {
        System.out.println("Question: " + a);
        System.out.print("Your answer: ");
    }

    public static String getName(Scanner s) {
        System.out.println("Welcome to the Brain Games");
        System.out.print("May I have your name? ");
        s.nextLine();
        String name = s.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void startGame(Map<String, String> map, String name, Scanner scan) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            question(s.getKey());
            String result = scan.nextLine();
            String answer = s.getValue();
            if (result.equals(answer)) {
                correctPart();
            } else {
                wrongPart(result, answer, name);
                return;
            }
        }
        congratsPart(name);
    }
}
