import java.util.ArrayList;

public class PathSum2 {

    class WrapperNode {
        int index;  // node index
        int prev;   // index of parent node
        TreeNode tnode;
        int pathsum;
        
        public WrapperNode(int prev, int index, TreeNode tnode, int pathsum) {
            this.prev = prev;
            this.index = index;
            this.tnode = tnode;
            this.pathsum = pathsum;
        }
        
        public boolean isLeaf() {
            return this.tnode.left == null && this.tnode.right == null;
        }
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<WrapperNode> stack = new ArrayList<WrapperNode>();
        ArrayList<WrapperNode> indexedNodes = new ArrayList<WrapperNode>();
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        
        int index = 0;
        if (root != null) {
            WrapperNode r = new WrapperNode(-1, index, root, root.val);
            stack.add(r);
            indexedNodes.add(r);
        }
        // DFS traverse and record prev and pathsum info
        while (!stack.isEmpty()) {
            WrapperNode node = stack.remove(stack.size()-1);
            if (node.tnode.left != null) {
                WrapperNode w = new WrapperNode(node.index, ++index, node.tnode.left,
                                                node.pathsum + node.tnode.left.val);
                stack.add(w);
                indexedNodes.add(w);
            }
            if (node.tnode.right != null) {
                WrapperNode w = new WrapperNode(node.index, ++index, node.tnode.right,
                                                node.pathsum + node.tnode.right.val);
                stack.add(w);
                indexedNodes.add(w);
            }
            if (node.isLeaf() && node.pathsum == sum) {
                leaves.add(node.index);
            }
        }
        // collect results
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int i : leaves) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            while (i != -1) {
                WrapperNode node = indexedNodes.get(i);
                path.add(0, node.tnode.val);
                i = node.prev;
            }
            results.add(path);
        }
        return results;
    }
}
