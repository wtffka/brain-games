package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        printGameMenu();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int gameNumber = scan.nextInt();
            chooseGameMenu(gameNumber);
            return;
        }
        scan.close();
    }

    private static void printGameMenu() {
        System.out.println("/Welcome to the Brain Games!/");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static void chooseGameMenu(int gameNumber) {
        switch (gameNumber) {

            case Constants.GREET_GAME:
                GreetGame.runGame();
                break;

            case Constants.EVEN_GAME:
                EvenGame.runGame();
                break;

            case Constants.CALC_GAME:
                CalcGame.runGame();
                break;

            case Constants.GCD_GAME:
                GCDGame.runGame();
                break;

            case Constants.PROGRESSION_GAME:
                ProgressionGame.runGame();
                break;

            case Constants.PRIME_GAME:
                PrimeGame.runGame();
                break;

            default:
                return;
        }
    }
}

