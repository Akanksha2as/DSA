import java.util.*;

public class SubstringsWithKDistinct {

    public static int substringsWithKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private static int atMostKDistinct(String s, int k) {
        int left = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        int result = substringsWithKDistinct(s, k);
        System.out.println("Substrings with exactly " + k + " distinct characters: " + result);
    }
}
