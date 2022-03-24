package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class GCDGame {

    private static final int MAX_VALUE = 100;
    private static Map<String, String> gameData = new LinkedHashMap<>();


    public static Map<String, String> generateGameData(Map<String, String> roundsData) {
        for (int i = 0; i < Constants.MAX_RIGHT_ANSWERS; i++) {
            int firstNum = Utils.generateRandomNumber(MAX_VALUE);
            int secondNum = Utils.generateRandomNumber(MAX_VALUE);
            String question = firstNum + " " + secondNum;
            String answer = String.valueOf(generateAnswer(firstNum, secondNum));
            roundsData.put(question, answer);
        }
        return roundsData;
    }

    public static void runGame() {
        Engine.runGame(generateGameData(gameData), Constants.GCD_GAME_RULE);
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
