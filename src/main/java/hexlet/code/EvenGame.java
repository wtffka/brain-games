package hexlet.code;
import java.util.Scanner;
public class EvenGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    public static void isNumberEvenOrNot() {
        var name = Cli.getName();
        var rightAnswers = 0;
        final var diapason = 100; // Диапазон чисел для задачи от 1 до 99
        final var maxRightAnswers = 3;
        double a = Math.random() * diapason;
        Scanner scan = new Scanner(System.in);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        addInformation(a);
        while (scan.hasNextLine()) {
            var answer = scan.nextLine();
            if (answer.equals(YES) || answer.equals(NO)) {
                boolean even = (int) a % 2 == 0;
                if (answer.equals(YES)) {
                    if (even) {
                        System.out.println("Correct!");
                        rightAnswers += 1;
                    } else {
                        System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                        System.out.println("Let's try again, " + name);
                        rightAnswers = 0;
                    }
                    a = Math.random() * diapason;
                }
                if (answer.equals(NO)) {
                    if (!even) {
                        System.out.println("Correct!");
                        rightAnswers += 1;
                    } else {
                        System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                        System.out.println("Let's try again, " + name);
                        rightAnswers = 0;
                    }
                    a = Math.random() * diapason;
                }
            } else {
                System.out.println(answer + " is wrong answer. Please answer correctly 'yes' or 'no'");
                rightAnswers = 0;
                a = Math.random() * diapason;
            }
            if (rightAnswers == maxRightAnswers) {
                System.out.println("Congratulations, " + name + "!");
                return;
            }
            addInformation(a);
        }
    }

    private static void addInformation(double a) {
        System.out.println("Question: " + (int) a);
        System.out.print("Your answer: ");
    }
}
