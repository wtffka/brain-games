package hexlet.code;

public class Engine {
    public static int newRandomNumber(int diapason) {
        var a = (int) (Math.random() * diapason);
        return a;
    }

    public static void wrongPart(String answer, String result, String name) {
        System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
        System.out.println("Let's try again, " + name + "!");
    }

    public static void congratsPart(String name) {
        System.out.println("Congratulations, " + name + "!");
    }
}
