package hexlet.code.games;

import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalcGame {

    public static Map<String, String> game() {
        Map<String, String> map = new LinkedHashMap<>();
        final var maxValue = 20;
        final var operationsQuantity = 3;
        for (int i = 0; i < operationsQuantity; i++) {
            int randomOperation = Utils.newRandomNumber(operationsQuantity);
            int a = Utils.newRandomNumber(maxValue);
            int b = Utils.newRandomNumber(maxValue);
            String operation = " + ";
            String question = a + operation + b;
            String result = String.valueOf(a + b);
            if (randomOperation == 1) {
                operation = " * ";
                question = a + operation + b;
                result = String.valueOf(a * b);
            } else if (randomOperation == 2) {
                operation = " - ";
                question = a + operation + b;
                result = String.valueOf(a - b);
            }
            map.put(question, result);
        }
        System.out.println("What is the result of the expression?");
        return map;
    }
}
