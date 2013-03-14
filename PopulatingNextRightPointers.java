public class PopulatingNextRightPointers {
    // recursive approach
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = (root.next != null) ? root.next.left : null;
        }
        connect1(root.left);
        connect1(root.right);
    }

    // non-recursive approach
    public void connect(TreeLinkNode root) {
        while (root != null && root.left != null) {
            TreeLinkNode nextlevel = root.left;  // fisrt node at the next level
            TreeLinkNode prevright = null;  // previous right child at the same level
            for (; root != null; root = root.next) {
                if (prevright != null) prevright.next = root.left;
                root.left.next = root.right;
                prevright = root.right;
            }
            root = nextlevel;
        }
    }
}
