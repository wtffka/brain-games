package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class EvenGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    private static Map<String, String> generateData() {
        Map<String, String> roundsData = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            generateRoundData(roundsData);
        }
        return roundsData;
    }

    private static void generateRoundData(Map<String, String> roundsData) {
        String question = String.valueOf(Utils.generateRandomNumber(MAX_VALUE));
        String result = Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
        roundsData.put(question, result);
    }

    public static void runGame() {
        Engine.runGame(generateData(), GAME_RULES);
    }
}
