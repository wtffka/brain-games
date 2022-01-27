package hexlet.code.games;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgressionGame {

    public static Map<String, String> game() {

        Map<String, String> map = new LinkedHashMap<>();
        final int minProgressionLength = 5;
        final int maxRightAnswers = 3;
        for (int i = 0; i < maxRightAnswers; i++) {
            int progressionLength = Utils.newRandomNumber(minProgressionLength) + minProgressionLength;
            int step = Utils.newRandomNumber(minProgressionLength);
            int progressionStartNumber = Utils.newRandomNumber(minProgressionLength);
            int missingElement = Utils.newRandomNumber(minProgressionLength - 2) + 1;
            String question = getQuestion(step, progressionStartNumber, missingElement, progressionLength);
            while (map.containsKey(question)) {
                progressionLength = Utils.newRandomNumber(minProgressionLength) + minProgressionLength;
                step = Utils.newRandomNumber(minProgressionLength);
                progressionStartNumber = Utils.newRandomNumber(minProgressionLength);
                missingElement = Utils.newRandomNumber(minProgressionLength - 2) + 1;
                question = getQuestion(step, progressionStartNumber, missingElement, progressionLength);
            }
            map.put(question, progressionGameLogic(question));
        }
        System.out.println("What number is missing in the progression?");
        return map;
    }

    public static String getQuestion(int progressionStep, int progressionStartNumber, int progressionMissingElement,
                                     int progressionLength) {
        int result = progressionStartNumber;
        int missingResult = 0;
        String question = String.valueOf(result);
        for (var i = 1; i < progressionLength; i++) {
            result = result + progressionStep;
            if (i == progressionMissingElement) {
                missingResult = result;
                question = question + " " + "..";
            } else {
                question = question + " " + result;
            }
        }
        return question;
    }

    public static String progressionGameLogic(String question) {
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
}
