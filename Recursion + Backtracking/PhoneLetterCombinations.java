//https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/1674334088/
import java.util.*;
public class PhoneLetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, new StringBuilder(), result, mapping);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result, String[] mapping) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(index + 1, digits, current, result, mapping);
            current.deleteCharAt(current.length() - 1); 
        }
    }

    public static void main(String[] args) {
        PhoneLetterCombinations obj = new PhoneLetterCombinations();
        String digits = "23";
        List<String> output = obj.letterCombinations(digits);
        System.out.println("Combinations: " + output);
    }
}
