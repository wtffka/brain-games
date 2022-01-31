package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static Map<String, String> generateData() {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int a = Utils.newRandomNumber(MAX_VALUE);
            String question = String.valueOf(a);
            String answer = calculateDivisors(question) > 0 ? "no" : "yes";
            map.put(question, answer);
        }
        return map;
    }

    public static void runGame() {
        Engine.runGame(generateData(), Engine.getName(), GAME_RULES);
    }

    private static int calculateDivisors(String a) {
        int intA = Integer.parseInt(a);
        var divisors = 0;
        for (int i = 2; i < intA; i++) {
            if (intA % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }
}
