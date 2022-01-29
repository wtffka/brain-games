package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcGame {
    static final int MAX_VALUE = 10;
    static final int OPERATIONS_QUANTITY = 3;
    static final char[] OPERATIONS = {' ', '+', '*', '-'};
    static final String GAME_RULES = "What is the result of the expression?";

    public static Map<String, String> generateData() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < OPERATIONS_QUANTITY; i++) {
            int randomOperation = Utils.newRandomNumber(OPERATIONS_QUANTITY);
            String operation = " " + OPERATIONS[randomOperation] + " ";
            int a = Utils.newRandomNumber(MAX_VALUE);
            int b = Utils.newRandomNumber(MAX_VALUE);
            String question = a + operation + b;
            question = changeKey(map, question, a, b);
            String result = calculate(a, b, operation);
            map.put(question, result);
        }
        return map;
    }

    public static void runGame(Scanner s) {
        Engine.startGame(generateData(), Engine.getName(s), s, GAME_RULES);
    }

    public static String calculate(int a, int b, String operation) {
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

    public static String changeKey(Map<String, String> map, String question, int a, int b) {
        while (map.containsKey(question)) {
            int randomOperation = Utils.newRandomNumber(OPERATIONS_QUANTITY);
            if (randomOperation == 1) {
                question = a + " + " + b;
            }
            if (randomOperation == 2) {
                question = a + " * " + b;
            } else {
                question = a + " - " + b;
            }
        }
        return question;
    }
}
