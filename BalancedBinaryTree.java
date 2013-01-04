public class BalancedBinaryTree {
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1)
            throw new RuntimeException("not balanced");
        return 1 + Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        try {
            depth(root);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
