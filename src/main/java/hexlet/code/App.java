package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    static final int GREET_GAME = 1;
    static final int EVEN_GAME = 2;
    static final int CALC_GAME = 3;
    static final int GCD_GAME = 4;
    static final int PROGRESSION_GAME = 5;
    static final int PRIME_GAME = 6;

    public static void main(String[] args) {
        chooseGame();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int gameNumber = scan.nextInt();
            switch (gameNumber) {

                case GREET_GAME:
                    GreetGame.runGame();
                    break;

                case EVEN_GAME:
                    EvenGame.runGame();
                    break;

                case CALC_GAME:
                    CalcGame.runGame();
                    break;

                case GCD_GAME:
                    GCDGame.runGame();
                    break;

                case PROGRESSION_GAME:
                    ProgressionGame.runGame();
                    break;

                case PRIME_GAME:
                    PrimeGame.runGame();
                    break;

                default:
                    return;
            }
            return;
        }
        scan.close();
    }

    public static void chooseGame() {
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
}

