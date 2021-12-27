package hexlet.code.games;
import java.util.Scanner;

public class GreetGame {

    public static String getName() {
        System.out.println("Welcome to the Brain Games");
        System.out.print("May I have your name? ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}

