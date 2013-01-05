public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) return head;
        int size = 0;
        ListNode p = head;
        while (true) {
            size++;
            if (p.next == null) {
                p.next = head;
                break;
            }
            p = p.next;
        }
        p = p.next; // p point to head
        n = n % size;
        for (int i=size-n-1; i > 0; i--) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
