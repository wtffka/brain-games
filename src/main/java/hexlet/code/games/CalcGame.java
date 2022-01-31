package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;

public class CalcGame {
    static final int MAX_VALUE = 20;
    static final int OPERATIONS_QUANTITY = 3;
    static final int MAX_RIGHT_ANSWERS = 3;
    static final char[] OPERATIONS = {' ', '+', '*', '-'};
    static final String GAME_RULES = "What is the result of the expression?";

    private static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int randomOperation = Utils.newRandomNumber(OPERATIONS_QUANTITY);
            String operation = " " + OPERATIONS[randomOperation] + " ";
            int a = Utils.newRandomNumber(MAX_VALUE);
            int b = Utils.newRandomNumber(MAX_VALUE);
            String question = a + operation + b;
            String answer = generateAnswer(a, b, operation);
            map.put(question, answer);
        }
        return map;
    }

    public static void runGame() {
        Engine.runGame(generateData(), Engine.getName(), GAME_RULES);
    }

    private static String generateAnswer(int a, int b, String operation) {
        if (operation.equals(" + ")) {
            return String.valueOf(a + b);
        }
        if (operation.equals(" * ")) {
            return String.valueOf(a * b);
        }
        if (operation.equals(" - ")) {
            return String.valueOf(a - b);
        }
        return "";
    }
}
