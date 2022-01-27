package hexlet.code.games;
import hexlet.code.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class EvenGame {

    public static Map<String, String> game() {
        final int maxValue = 100;
        final int maxRightAnswers = 3;
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < maxRightAnswers; i++) {
            String key = String.valueOf(Utils.newRandomNumber(maxValue));
            while (map.containsKey(key)) {
                key = String.valueOf(Utils.newRandomNumber(maxValue));
            }
            map.put(key, Integer.parseInt(key) % 2 == 0 ? "yes" : "no");
        }
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        return map;
    }
}
