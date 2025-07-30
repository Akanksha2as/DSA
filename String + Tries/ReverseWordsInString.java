//https://leetcode.com/problems/reverse-words-in-a-string/submissions/1716874886/
public class ReverseWordsInString {

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "  the sky   is blue  ";
        String reversed = reverseWords(input);
        System.out.println("Reversed: \"" + reversed + "\"");
    }
}
