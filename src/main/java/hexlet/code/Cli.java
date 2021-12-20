package hexlet.code;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cli {

    public static void getName() {
        System.out.println("May I have your name? ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Hello, " + name + "!");
        s.close();

    }
}

