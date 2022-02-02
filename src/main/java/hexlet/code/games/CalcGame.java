package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalcGame {
    static final int MAX_VALUE = 20;
    static final int OPERATIONS_QUANTITY = 3;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final char[] OPERATIONS = {'+', '*', '-'};
    static final String GAME_RULES = "What is the result of the expression?";

    private static Map<String, String> generateData() {
        Map<String, String> roundsData = new LinkedHashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            generateRoundData(roundsData);
        }
        return roundsData;
    }

    private static void generateRoundData(Map<String, String> roundsData) {
        int randomOperation = Utils.generateRandomNumber(OPERATIONS_QUANTITY) - 1;
        char operation = OPERATIONS[randomOperation];
        int firstNumber = Utils.generateRandomNumber(MAX_VALUE);
        int secondNumber = Utils.generateRandomNumber(MAX_VALUE);
        String question = firstNumber + " " +  operation + " " + secondNumber;
        String answer = generateAnswer(firstNumber, secondNumber, operation);
        roundsData.put(question, answer);
    }

    public static void runGame() {
        Engine.runGame(generateData(), GAME_RULES);
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
