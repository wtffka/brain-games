package hexlet.code;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        final var greetGame = 1;
        final var evenGame = 2;
        final var calcGame = 3;
        introduction();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            var gameNumber = scan.nextInt();
            switch (gameNumber) {
                case 0:
                    return;

                case greetGame:
                    System.out.println("Welcome to the Brain Games");
                    Cli.getName();
                    break;

                case evenGame:
                    System.out.println("Welcome to the Brain Games");
                    EvenGame.isNumberEvenOrNot();
                    break;

                case calcGame:
                    System.out.println("Welcome to the Brain Games");
                    CalcGame.randomCalcOperation();
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
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
