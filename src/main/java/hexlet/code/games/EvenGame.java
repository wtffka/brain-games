package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    public static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            String key = String.valueOf(Utils.newRandomNumber(MAX_VALUE));
            changeKey(map, key);
            map.put(key, Integer.parseInt(key) % 2 == 0 ? "yes" : "no");
        }
        return map;
    }

    public static void runGame(Scanner s) {
        Engine.startGame(generateData(), Engine.getName(s), s, GAME_RULES);
    }

    public static String changeKey(Map<String, String> map, String key) {
        while (map.containsKey(key)) {
            key = String.valueOf(Utils.newRandomNumber(MAX_VALUE));
        }
        return key;
    }
}
