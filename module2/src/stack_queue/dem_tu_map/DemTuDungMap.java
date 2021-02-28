package stack_queue.dem_tu_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DemTuDungMap {
    public static void countWord(String keyStr) {
        Map<Character, Integer> map = new TreeMap<>();
        keyStr = keyStr.replaceAll("\\s+","").toLowerCase();
        for (int i = 0; i < keyStr.length(); i++) {
            if (map.containsKey(keyStr.charAt(i))) {
                map.put(keyStr.charAt(i),map.get(keyStr.charAt(i))+1);
            } else
                map.put(keyStr.charAt(i), 1);
        }
        for (Character key:map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyStr = input.nextLine();
        countWord(keyStr);
    }
}
