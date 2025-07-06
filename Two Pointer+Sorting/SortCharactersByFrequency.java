//https://leetcode.com/problems/sort-characters-by-frequency/submissions/1688235573/?envType=problem-list-v2&envId=sorting
import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
       
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();
        String input = "tree";
        System.out.println("Sorted by frequency: " + scbf.frequencySort(input));
    }
}
