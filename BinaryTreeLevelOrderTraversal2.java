import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        // dist[i] is distance from node queue[i] to root
        ArrayDeque<Integer> dist = new ArrayDeque<Integer>();
        queue.add(root);
        dist.add(0);
        
        int predist = -1;
        ArrayList<Integer> level = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            int node_dist = dist.removeFirst();
            if (node_dist != predist) {
                if (level != null) result.add(level);
                level = new ArrayList<Integer>();
                predist = node_dist;
            }
            level.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                dist.add(node_dist+1);
            }
            if (node.right != null) {
                queue.add(node.right);
                dist.add(node_dist+1);
            }
        }
        result.add(level);
        
        Collections.reverse(result);
        return result;
    }
}
