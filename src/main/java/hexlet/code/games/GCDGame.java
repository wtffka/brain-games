package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GCDGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int a = Utils.newRandomNumber(MAX_VALUE);
            int b = Utils.newRandomNumber(MAX_VALUE);
            String question = a + " " + b;
            changeKey(map, question);
            String result = String.valueOf(calculateResult(a, b));
            map.put(question, result);
        }
        return map;
    }

    public static void runGame(Scanner s) {
        Engine.startGame(generateData(), Engine.getName(s), s, GAME_RULES);
    }

    public static String changeKey(Map<String, String> map, String question) {
        while (map.containsKey(question)) {
            int a = Utils.newRandomNumber(MAX_VALUE);
            int b = Utils.newRandomNumber(MAX_VALUE);
            question = a + " " + b;
        }
        return question;
    }

    public static int calculateResult(int a, int b) {
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
