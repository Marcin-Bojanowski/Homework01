package pl.coderslab.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {


    public static void main(String[] args) {
        Map<Integer, Integer> map = checkRand(500000, 10);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }


    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < interval; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < amount; i++) {
            Integer r = random.nextInt(interval);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (r.equals(entry.getKey())) {
                    map.put(entry.getKey(), entry.getValue() + 1);
                }
            }
        }
        return map;
    }
}

