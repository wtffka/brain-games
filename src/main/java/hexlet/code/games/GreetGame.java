package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class GreetGame {

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        Engine.getName(scanner);
    }
}
