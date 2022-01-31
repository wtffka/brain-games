package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;

public class ProgressionGame {
    static final int MIN_PROGRESSION_LENGTH = 5;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "What number is missing in the progression?";

    private static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int progressionLength = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
            int step = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int progressionStartNumber = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int missingElement = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH - 2) + 1;
            generateQuestion(step, progressionStartNumber, progressionLength, missingElement, map);
        }
        return map;
    }

    public static void runGame() {
        Engine.runGame(generateData(), Engine.getName(), GAME_RULES);
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
