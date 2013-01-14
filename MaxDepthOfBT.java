import java.util.ArrayDeque;

public class MaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        // corresponding depth of each node
        ArrayDeque<Integer> depths = new ArrayDeque<Integer>();
        queue.addLast(root);
        depths.addLast(1);
        int max = Integer.MIN_VALUE;
        // BFS traverse
        while (!queue.isEmpty()) {
            TreeNode n = queue.removeFirst();
            int d = depths.removeFirst();
            if (n.left != null) {
                queue.addLast(n.left);
                depths.addLast(d+1);
            }
            if (n.right != null) {
                queue.addLast(n.right);
                depths.addLast(d+1);
            }
            if (n.left == null && n.right == null && max < d) {
                max = d;
            }
        }
        return max;

    }
}
