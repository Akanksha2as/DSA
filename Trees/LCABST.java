//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/1703092171/?envType=problem-list-v2&envId=binary-search-tree
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LCABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;         // Node with value 2
        TreeNode q = root.left.right;   // Node with value 4

        LCABST lcaFinder = new LCABST();
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}
