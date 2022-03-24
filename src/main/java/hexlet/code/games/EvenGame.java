package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class EvenGame {

    private static final int MAX_VALUE = 100;
    private static Map<String, String> gameData = new LinkedHashMap<>();

    private static Map<String, String> generateGameData(Map<String, String> roundsData) {
        for (int i = 0; i < Constants.MAX_RIGHT_ANSWERS; i++) {
            String question = String.valueOf(Utils.generateRandomNumber(MAX_VALUE));
            String result = Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
            roundsData.put(question, result);
        }
        return roundsData;
    }

    public static void runGame() {
        Engine.runGame(generateGameData(gameData), Constants.EVEN_GAME_RULE);
    }
}
