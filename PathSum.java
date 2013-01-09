class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        int newsum = sum - root.val;
        return hasPathSum(root.left, newsum) || hasPathSum(root.right, newsum);
    }
}
