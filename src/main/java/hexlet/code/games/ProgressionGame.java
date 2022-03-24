package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class ProgressionGame {

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static Map<String, String> gameData = new LinkedHashMap<>();

    private static Map<String, String> generateGameData(Map<String, String> roundsData) {
        for (int i = 0; i < Constants.MAX_RIGHT_ANSWERS; i++) {
            int progressionLength = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
            int step = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH);
            int progressionStartNumber = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH);
            int missingElement = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH - 2) + 1;
            List<String> roundList = generateQuestion(step, progressionStartNumber, progressionLength, missingElement);
            roundsData.put(roundList.get(0), roundList.get(1));
        }
        return roundsData;
    }

    public static void runGame() {
        Engine.runGame(generateGameData(gameData), Constants.PROGRESSION_GAME_RULE);
    }

    private static List<String> generateQuestion(int progressionStep, int progressionStartNumber, int progressionLength,
                                          int progressionMissingElement) {
        List<String> dataList = new LinkedList<>();
        int result = progressionStartNumber;
        String question = String.valueOf(result);
        String answer = "";
        for (var i = 1; i < progressionLength; i++) {
            result = result + progressionStep;
            if (i == progressionMissingElement) {
                question = question + " ..";
                answer = String.valueOf(result);
            } else {
                question = question + " " + result;
            }
        }
        dataList.add(question);
        dataList.add(answer);
        return dataList;
    }
}
