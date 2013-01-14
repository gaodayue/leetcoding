import java.util.ArrayDeque;

public class MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        // corresponding depth of each node
        ArrayDeque<Integer> depths = new ArrayDeque<Integer>();
        queue.addLast(root);
        depths.addLast(1);
        int d = -1;
        while (true) {
            TreeNode n = queue.removeFirst();
            d = depths.removeFirst();
            if (n.left == null && n.right == null) {
                break;
            }
            if (n.left != null) {
                queue.addLast(n.left);
                depths.addLast(d+1);
            }
            if (n.right != null) {
                queue.addLast(n.right);
                depths.addLast(d+1);
            }
        }
        return d;
    }
}
