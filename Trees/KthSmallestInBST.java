//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/1701996542/?envType=problem-list-v2&envId=binary-search-tree
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallestInBST {

    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestInBST tree = new KthSmallestInBST();
        int k = 2;
        int res = tree.kthSmallest(root, k);

        System.out.println("Kth Smallest Element: " + res);
    }
}
