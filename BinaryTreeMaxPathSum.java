public class BinaryTreeMaxPathSum {
    public static final int VERY_SMALL_NUMBER = -999999999;
    
    private class MyMax {
        int imax;   // max inlucde current root node
        int emax;   // max exclude current root node
        
        public MyMax() {
            this.imax = this.emax = VERY_SMALL_NUMBER;
        }
        
        public MyMax(int imax, int emax) {
            this.imax = imax;
            this.emax = emax;
        }
        
        public int bigger() {
            return (imax > emax) ? imax : emax;
        }
    }
    
    private int max(int ...numbers) {
        int m = Integer.MIN_VALUE;
        for (int i=0; i < numbers.length; i++) {
            if (m < numbers[i]) {
                m = numbers[i];
            }
        }
        return m;
    }
    
    private MyMax pathsum(TreeNode root) {
        if (root.left == null && root.right == null)
            return new MyMax(root.val, VERY_SMALL_NUMBER);
        MyMax leftmax  = (root.left != null)  ? pathsum(root.left)  : new MyMax();
        MyMax rightmax = (root.right != null) ? pathsum(root.right) : new MyMax();
        
        MyMax rtn = new MyMax();
        rtn.imax = max(root.val,
                       leftmax.imax+root.val,
                       rightmax.imax+root.val);
        rtn.emax = max(leftmax.bigger(),
                       rightmax.bigger(),
                       leftmax.imax+rightmax.imax+root.val);
        
        return rtn;
    }
    
    public int maxPathSum(TreeNode root) {
        return pathsum(root).bigger();
    }
}
