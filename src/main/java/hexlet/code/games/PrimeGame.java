package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrimeGame {
    static final int MAX_VALUE = 10;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static Map<String, String> generateData() {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int a = Utils.newRandomNumber(MAX_VALUE);
            String key = String.valueOf(a);
            key = changeKey(map, key);
            map.put(key, divisors(key) > 0 ? "no" : "yes");
        }
        return map;
    }

    public static void runGame(Scanner s) {
        Engine.startGame(generateData(), Engine.getName(s), s, GAME_RULES);
    }

    public static int divisors(String a) {
        int intA = Integer.parseInt(a);
        var divisors = 0;
        for (int i = 2; i < intA; i++) {
            if (intA % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }

    public static String changeKey(Map<String, String> map, String key) {
        while (map.containsKey(key) || key.equals("1")) {
            key = String.valueOf(Utils.newRandomNumber(MAX_VALUE));
        }
        return key;
    }
}
