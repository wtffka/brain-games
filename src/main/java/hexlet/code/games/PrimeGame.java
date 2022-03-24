package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeGame {

    private static final int MAX_VALUE = 100;
    private static Map<String, String> gameData = new LinkedHashMap<>();

    private static Map<String, String> generateGameData(Map<String, String> roundsData) {
        for (int i = 0; i < Constants.MAX_RIGHT_ANSWERS; i++) {
            int gameNumber = Utils.generateRandomNumber(MAX_VALUE);
            String question = String.valueOf(gameNumber);
            String answer = calculateDivisors(question) > 0 ? "no" : "yes";
            roundsData.put(question, answer);
        }
        return roundsData;
    }

    public static void runGame() {
        Engine.runGame(generateGameData(gameData), Constants.PRIME_GAME_RULE);
    }

    private static int calculateDivisors(String question) {
        int gameNumber = Integer.parseInt(question);
        var divisors = 0;
        for (int i = 2; i < gameNumber; i++) {
            if (gameNumber % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }
}
