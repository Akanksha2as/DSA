//https://leetcode.com/problems/diameter-of-binary-tree/submissions/1700720067/
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDiameter {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        System.out.println("Diameter of Binary Tree: " + tree.diameterOfBinaryTree(root));
    }
}
