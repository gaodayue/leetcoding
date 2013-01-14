public class ConstructBinaryTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // find root position
        int rootpos = -1;
        for (int i=0; i < len; i++) {
            if (root.val == inorder[i]) {
                rootpos = i;
                break;
            }
        }
        
        if (rootpos != 0) {
            int[] left_preorder = new int[rootpos];
            int[] left_inorder = new int[rootpos];
            System.arraycopy(preorder, 1, left_preorder, 0, rootpos);
            System.arraycopy(inorder, 0, left_inorder, 0, rootpos);
            root.left = buildTree(left_preorder, left_inorder);
        }
        
        if (rootpos != len-1) {
            int[] right_preorder = new int[len-rootpos-1];
            int[] right_inorder = new int[len-rootpos-1];
            System.arraycopy(preorder, rootpos+1, right_preorder, 0, len-rootpos-1);
            System.arraycopy(inorder, rootpos+1, right_inorder, 0, len-rootpos-1);
            root.right = buildTree(right_preorder, right_inorder);
        }
        
        return root;
    }
}
