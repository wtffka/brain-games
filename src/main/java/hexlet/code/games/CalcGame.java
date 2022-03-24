package hexlet.code.games;

import hexlet.code.Constants;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalcGame {

    private static final int MAX_VALUE = 20;
    private static final char[] OPERATIONS = {'+', '*', '-'};
    private static Map<String, String> gameData = new LinkedHashMap<>();

    private static Map<String, String> generateGameData(Map<String, String> roundsData) {
        for (int i = 0; i < Constants.MAX_RIGHT_ANSWERS; i++) {
            int randomOperation = Utils.generateRandomNumber(OPERATIONS.length) - 1;
            char operation = OPERATIONS[randomOperation];
            int firstNumber = Utils.generateRandomNumber(MAX_VALUE);
            int secondNumber = Utils.generateRandomNumber(MAX_VALUE);
            String question = firstNumber + " " + operation + " " + secondNumber;
            String answer = generateAnswer(firstNumber, secondNumber, operation);
            roundsData.put(question, answer);
        }
        return roundsData;
    }

    public static void runGame() {
        Engine.runGame(generateGameData(gameData), Constants.CALC_GAME_RULE);
    }

    private static String generateAnswer(int firstNum, int secondNum, char operation) {
        if (operation == '+') {
            return String.valueOf(firstNum + secondNum);
        }
        if ((operation == '*')) {
            return String.valueOf(firstNum * secondNum);
        }
        if ((operation == '-')) {
            return String.valueOf(firstNum - secondNum);
        }
        return "";
    }
}
