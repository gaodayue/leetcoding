import java.util.ArrayDeque;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal{
    
    class EnhancedTreeNode {
        TreeNode node;
        int hight;
        EnhancedTreeNode(TreeNode node, int hight) {
            this.node = node;
            this.hight = hight;
        }
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        ArrayDeque<EnhancedTreeNode> queue = new ArrayDeque<EnhancedTreeNode>();
        queue.addLast(new EnhancedTreeNode(root, 0));
        
        int pre = -1;
        ArrayList<Integer> level = null;
        while (!queue.isEmpty()) {
            EnhancedTreeNode enode = queue.removeFirst();
            if (enode.hight != pre) {
                if (level != null) {
                    result.add(level);
                }
                level = new ArrayList<Integer>();
                pre = enode.hight;
            }
            level.add(enode.node.val);
            if (enode.node.left != null) {
                queue.addLast(new EnhancedTreeNode(enode.node.left, pre+1));
            }
            if (enode.node.right != null) {
                queue.addLast(new EnhancedTreeNode(enode.node.right, pre+1));
            }
        }
        result.add(level);
        return result;
    }
}
