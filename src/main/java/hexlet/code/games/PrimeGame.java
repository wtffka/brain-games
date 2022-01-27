package hexlet.code.games;

import hexlet.code.Utils;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeGame {

    public static Map<String, String> game() {
        Map<String, String> map = new LinkedHashMap<>();
        final var maxValue = 50;
        final var maxRightAnswers = 3;
        for (int i = 0; i < maxRightAnswers; i++) {
            int a = Utils.newRandomNumber(maxValue);
            map.put(String.valueOf(a), divisors(a) > 0 ? "no" : "yes");
        }
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        return map;
    }

    public static int divisors(int a) {
        var divisors = 0;
        for (var i = 2; i < a; i++) {
            if (a % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }
}
