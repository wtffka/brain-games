package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProgressionGame {
    static final int MIN_PROGRESSION_LENGTH = 5;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "What number is missing in the progression?";

    private static Map<String, String> generateData() {
        Map<String, String> roundsData = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            generateRoundData(roundsData);
        }
        return roundsData;
    }

    private static void generateRoundData(Map<String, String> roundsData) {
        int progressionLength = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
        int step = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH);
        int progressionStartNumber = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH);
        int missingElement = Utils.generateRandomNumber(MIN_PROGRESSION_LENGTH - 2) + 1;
        generateQuestion(step, progressionStartNumber, progressionLength, missingElement, roundsData);
    }

    public static void runGame() {
        Engine.runGame(generateData(), GAME_RULES);
    }

    private static void generateQuestion(int progressionStep, int progressionStartNumber, int progressionLength,
                                          int progressionMissingElement, Map<String, String> map) {
        int result = progressionStartNumber;
        String question = String.valueOf(result);
        String answer = "";
        for (var i = 1; i < progressionLength; i++) {
            result = result + progressionStep;
            if (i == progressionMissingElement) {
                question = question + " " + "..";
                answer = String.valueOf(result);
            } else {
                question = question + " " + result;
            }
        }
        map.put(question, answer);
    }

}
