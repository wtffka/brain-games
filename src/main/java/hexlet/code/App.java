package hexlet.code;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        introduction();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            var gameNumber = scan.nextInt();
            switch (gameNumber) {
                case 0:
                    return;

                case 1:
                    System.out.println("Welcome to the Brain Games");
                    Cli.getName();
                    break;

                case 2:
                    System.out.println("Welcome to the Brain Games");
                    Even.isNumberEvenOrNot();
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
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
