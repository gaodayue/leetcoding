public class FlattenBinaryTreeToLinkedList {
    private TreeNode recurFlat(TreeNode root) {
        TreeNode leftLeaf  = (root.left == null)  ? root : recurFlat(root.left);
        TreeNode rightLeaf = (root.right == null) ? leftLeaf : recurFlat(root.right);
        
        TreeNode oldleft  = root.left;
        root.left = null;
        if (oldleft != null) {
            leftLeaf.right = root.right;
            root.right = oldleft;
        }
        
        return rightLeaf;
    }
    
    public void flatten(TreeNode root) {
        if (root != null) {
            recurFlat(root);
        }
    }
}
