package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final var greetGame = 1;
        final var evenGame = 2;
        final var calcGame = 3;
        final var gcdGame = 4;
        final var progressionGame = 5;
        final var primeGame = 6;
        String name;
        introduction();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int gameNumber = scan.nextInt();
            switch (gameNumber) {
                case 0:
                    return;

                case greetGame:
                    Engine.getName(scan);
                    break;

                case evenGame:
                    name = Engine.getName(scan);
                    Engine.startGame(EvenGame.game(), name, scan);
                    break;

                case calcGame:
                    name = Engine.getName(scan);
                    Engine.startGame(CalcGame.game(), name, scan);
                    break;

                case gcdGame:
                    name = Engine.getName(scan);
                    Engine.startGame(GCDGame.game(), name, scan);
                    break;

                case progressionGame:
                    name = Engine.getName(scan);
                    Engine.startGame(ProgressionGame.game(), name, scan);
                    break;

                case primeGame:
                    name = Engine.getName(scan);
                    Engine.startGame(PrimeGame.game(), name, scan);
                    break;

                default:
                    return;
            }
            return;
        }
        scan.close();
    }
    public static void introduction() {
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

