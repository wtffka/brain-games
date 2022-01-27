package hexlet.code.games;

import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

public class PrimeGame {

    public static Map<String, String> game() {
        Map<String, String> map = new HashMap<>();
        final int maxValue = 5;
        final int maxRightAnswers = 3;
        for (int i = 0; i < maxRightAnswers; i++) {
            String key = String.valueOf(Utils.newRandomNumber(maxValue));
            while (map.containsKey(key) || key.equals("1")) {
                key = String.valueOf(Utils.newRandomNumber(maxValue));
            }
            map.put(key, divisors(key) > 0 ? "no" : "yes");
        }
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        return map;
    }

    public static int divisors(String a) {
        int number = Integer.parseInt(a);
        var divisors = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisors++;
            }
        }
        return divisors;
    }
}
