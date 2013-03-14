public class PopulatingNextRightPointers2 {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode next = null; // first node of next level
            TreeLinkNode prev = null; // previous node at the same level
            for (; root != null; root = root.next) {
                if (next == null) {
                    next = (root.left != null) ? root.left : root.right;
                }
                if (root.left != null) {
                    if (prev != null) prev.next = root.left;
                    prev = root.left;
                }
                if (root.right != null) {
                    if (prev != null) prev.next = root.right;
                    prev = root.right;
                }
            }
            root = next;
        }
    }
}
