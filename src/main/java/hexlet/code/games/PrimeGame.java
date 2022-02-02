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
        Map<String, String> roundsData = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            generateRoundData(roundsData);
        }
        return roundsData;
    }

    private static void generateRoundData(Map<String, String> roundsData) {
        int gameNumber = Utils.generateRandomNumber(MAX_VALUE);
        String question = String.valueOf(gameNumber);
        String answer = calculateDivisors(question) > 0 ? "no" : "yes";
        roundsData.put(question, answer);
    }

    public static void runGame() {
        Engine.runGame(generateData(), GAME_RULES);
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
