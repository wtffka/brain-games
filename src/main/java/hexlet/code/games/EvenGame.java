package hexlet.code.games;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class EvenGame {

    public static Map<String, String> game() {
        final var maxValue = 100;
        final var maxRightAnswers = 3;
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < maxRightAnswers; i++) {
            int a = Utils.newRandomNumber(maxValue);
            map.put(String.valueOf(a), a % 2 == 0 ? "yes" : "no");
        }
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        return map;
    }
}
