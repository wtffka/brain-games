package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgressionGame {
    static final int MIN_PROGRESSION_LENGTH = 5;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final String GAME_RULES = "What number is missing in the progression?";

    public static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int progressionLength = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
            int step = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int progressionStartNumber = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int missingElement = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH - 2) + 1;
            String question = getQuestion(step, progressionStartNumber, missingElement, progressionLength);
            question = changeKey(map, question);
            map.put(question, calculateResult(question));
        }
        return map;
    }

    public static void runGame(Scanner s) {
        Engine.startGame(generateData(), Engine.getName(s), s, GAME_RULES);
    }

    public static String getQuestion(int progressionStep, int progressionStartNumber, int progressionMissingElement,
                                     int progressionLength) {
        int result = progressionStartNumber;
        String question = String.valueOf(result);
        for (var i = 1; i < progressionLength; i++) {
            result = result + progressionStep;
            if (i == progressionMissingElement) {
                question = question + " " + "..";
            } else {
                question = question + " " + result;
            }
        }
        return question;
    }

    public static String calculateResult(String question) {
        String[] arr = question.split("\\.\\.");
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] arr1 = arr[i].split(" ");
            if (i == 0) {
                a = Integer.parseInt(arr1[arr1.length - 1]);
            }
            if (i == 1) {
                b = Integer.parseInt(arr1[1]);
            }
        }
        return String.valueOf(a + ((b - a) / 2));
    }

    public static String changeKey(Map<String, String> map, String question) {
        while (map.containsKey(question)) {
            int progressionLength = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
            int step = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int progressionStartNumber = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH);
            int missingElement = Utils.newRandomNumber(MIN_PROGRESSION_LENGTH - 2) + 1;
            question = getQuestion(step, progressionStartNumber, missingElement, progressionLength);
        }
        return question;
    }
}
