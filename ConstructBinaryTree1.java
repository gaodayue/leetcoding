public class ConstructBinaryTree1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(postorder[len-1]);
        // reverse find root position in inorder array
        int rootpos = -1;
        for (int i=len-1; i >= 0; i--) {
            if (inorder[i] == root.val) {
                rootpos = i;
                break;
            }
        }
        
        if (rootpos != 0) {
            int[] left_inorder = new int[rootpos];
            int[] left_postorder = new int[rootpos];
            System.arraycopy(inorder, 0, left_inorder, 0, rootpos);
            System.arraycopy(postorder, 0, left_postorder, 0, rootpos);
            root.left = buildTree(left_inorder, left_postorder);
        }
        
        if (rootpos != len-1) {
            int[] right_inorder = new int[len-rootpos-1];
            int[] right_postorder = new int[len-rootpos-1];
            System.arraycopy(inorder, rootpos+1, right_inorder, 0, len-rootpos-1);
            System.arraycopy(postorder, rootpos, right_postorder, 0, len-rootpos-1);
            root.right = buildTree(right_inorder, right_postorder);
        }
        
        return root;
    }
}
