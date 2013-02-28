public class SumRootToLeafNumbers {
    private int sumRecur(TreeNode root, int acc) {
        int n = acc + root.val;
        if (root.left == null && root.right == null)
            return n;
        int sum = 0;
        if (root.left != null) {
            sum += sumRecur(root.left, n*10);
        }
        if (root.right != null) {
            sum += sumRecur(root.right, n*10);
        }
        return sum;
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        else              return sumRecur(root, 0);
    }
}
