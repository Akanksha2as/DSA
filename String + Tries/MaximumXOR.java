//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/submissions/1716891840/
public class MaximumXOR {

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    private static void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private static int getMaxXOR(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) insert(num);
        for (int num : nums) max = Math.max(max, getMaxXOR(num));
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR: " + findMaximumXOR(nums)); 
    }
}
