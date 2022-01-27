package hexlet.code;

public class Utils {

    public static int newRandomNumber(int maxValue) {
        return (int) ((Math.random() * maxValue) + 1);
    }
}
