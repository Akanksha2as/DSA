//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/1701202042/?envType=problem-list-v2&envId=stack
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void main(String[] args) {
    
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        List<Integer> result = traversal.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
