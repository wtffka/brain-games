package hexlet.code;

public class Utils {

    public static int generateRandomNumber(int maxValue) {
        return (int) ((Math.random() * maxValue) + 1);
    }
}
