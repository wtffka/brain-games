package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class GCDGame {
    static final int MAX_VALUE = 100;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    private static Map<String, String> generateData() {
        Map<String, String> roundsData = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            generateRoundData(roundsData);
        }
        return roundsData;
    }

    private static void generateRoundData(Map<String, String> roundsData) {
        int firstNum = Utils.generateRandomNumber(MAX_VALUE);
        int secondNum = Utils.generateRandomNumber(MAX_VALUE);
        String question = firstNum + " " + secondNum;
        String answer = String.valueOf(generateAnswer(firstNum, secondNum));
        roundsData.put(question, answer);
    }

    public static void runGame() {
        Engine.runGame(generateData(), GAME_RULES);
    }

    private static int generateAnswer(int firstNum, int secondNum) {
        var result = 0;
        if (firstNum == secondNum) {
            return firstNum;
        }
        if (firstNum > secondNum) {
            for (var i = 1; i <= secondNum; i++) {
                if (firstNum % i == 0 && secondNum % i == 0) {
                    result = i;
                }
            }
        } else {
            for (var i = 1; i <= firstNum; i++) {
                if (firstNum % i == 0 && secondNum % i == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
