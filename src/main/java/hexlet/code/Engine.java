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

    public static int calcGameLogic(int answer, int a, int b, int operation, String name) {
        var result = 0;
        if (operation == 0) {
            result = a + b;
        } else if (operation == 1) {
            result = a * b;
        } else if (operation == 2) {
            result = a - b;
        }
        if (result == answer) {
            System.out.println("Correct!");
            return 1;
        } else {
            Engine.wrongPart(String.valueOf(answer), String.valueOf(result), name);
            return 0;
        }
    }
}
