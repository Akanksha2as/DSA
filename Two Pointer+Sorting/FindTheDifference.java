//https://leetcode.com/problems/find-the-difference/submissions/1689677528/?envType=problem-list-v2&envId=sorting
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char result = 0;

        for (char ch : s.toCharArray()) {
            result ^= ch;
        }

        for (char ch : t.toCharArray()) {
            result ^= ch;
        }

        return result;
    }

    public static void main(String[] args) {
        FindTheDifference solution = new FindTheDifference();

        String s = "abcd";
        String t = "abcde";

        System.out.println("Added character: " + solution.findTheDifference(s, t));  
    }
}
