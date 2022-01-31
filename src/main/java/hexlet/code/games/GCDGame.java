package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;

public class GCDGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    private static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int a = Utils.newRandomNumber(MAX_VALUE);
            int b = Utils.newRandomNumber(MAX_VALUE);
            String question = a + " " + b;
            String answer = String.valueOf(generateAnswer(a, b));
            map.put(question, answer);
        }
        return map;
    }

    public static void runGame() {
        Engine.runGame(generateData(), Engine.getName(), GAME_RULES);
    }

    private static int generateAnswer(int a, int b) {
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
