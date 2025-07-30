//https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/submissions/1716883373/?envType=problem-list-v2&envId=trie
public class CountPrefixSuffixPairsI {

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = i + 1; j < n; j++) {
                String t = words[j];
                if (t.length() >= s.length()
                    && t.startsWith(s)
                    && t.endsWith(s)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println(countPrefixSuffixPairs(words1)); 

        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println(countPrefixSuffixPairs(words2));  

        String[] words3 = {"abab", "ab"};
        System.out.println(countPrefixSuffixPairs(words3));  
    }
}
