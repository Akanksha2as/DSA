//https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/1701992963/?envType=problem-list-v2&envId=stack
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePreorderTraversal tree = new BinaryTreePreorderTraversal();
        List<Integer> res = tree.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + res);
    }
}
