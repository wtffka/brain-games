package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;

public class EvenGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    private static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            String question = String.valueOf(Utils.newRandomNumber(MAX_VALUE));
            String result = Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
            map.put(question, result);
        }
        return map;
    }

    public static void runGame() {
        Engine.runGame(generateData(), Engine.getName(), GAME_RULES);
    }
}
