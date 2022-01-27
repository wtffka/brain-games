package hexlet.code.games;

import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class GCDGame {

    public static Map<String, String> game() {
        final var maxValue = 100;
        final var maxRightAnswers = 3;
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < maxRightAnswers; i++) {
            int a = Utils.newRandomNumber(maxValue);
            int b = Utils.newRandomNumber(maxValue);
            String question = a + " " + b;
            String result = String.valueOf(gcdGameLogic(a, b));
            map.put(question, result);
        }
        System.out.println("Find the greatest common divisor of given numbers.");
        return map;
    }

    public static int gcdGameLogic(int a, int b) {
        var result = 0;
        if (a == b) {
            return a;
        }
        if (a > b) {
            for (var i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    result = i;
                }
            }
        } else {
            for (var i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
