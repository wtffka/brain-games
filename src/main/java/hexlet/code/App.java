package hexlet.code;
import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        final var greetGame = 1;
        final var evenGame = 2;
        final var calcGame = 3;
        final var gcdGame = 4;
        final var progression = 5;
        final var prime = 6;
        introduction();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            var gameNumber = scan.nextInt();
            switch (gameNumber) {
                case 0:
                    return;

                case greetGame:
                    System.out.println("Welcome to the Brain Games");
                    GreetGame.getName();
                    break;

                case evenGame:
                    System.out.println("Welcome to the Brain Games");
                    EvenGame.isNumberEvenOrNot();
                    break;

                case calcGame:
                    System.out.println("Welcome to the Brain Games");
                    CalcGame.randomCalcOperation();
                    break;

                case gcdGame:
                    System.out.println("Welcome to the Brain Games");
                    GCDGame.gcdGame();
                    break;

                case progression:
                    System.out.println("Welcome to the Brain Games");
                    ProgressionGame.progressionGame();
                    break;

                case prime:
                    System.out.println("Welcome to the Brain Games");
                    PrimeGame.primeGame();
                    break;

                default:
                    break;
            }
            introduction();
        }
    }
    public static void introduction() {
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
