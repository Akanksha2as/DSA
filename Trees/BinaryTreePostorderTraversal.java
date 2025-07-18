//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/1701989718/?envType=problem-list-v2&envId=stack
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    public static void main(String[] args) {
   
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePostorderTraversal tree = new BinaryTreePostorderTraversal();
        List<Integer> res = tree.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + res);
    }
}
