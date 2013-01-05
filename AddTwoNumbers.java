public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        int carry = 0;
        while (l1 != null || l2 != null) {
            p.next = new ListNode(carry);
            p = p.next;
            if (l1 != null) {
                p.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                p.val += l2.val;
                l2 = l2.next;
            }
            carry = (p.val >= 10) ? 1 : 0;
            p.val %= 10;
        }
        if (carry == 1) p.next = new ListNode(1);
        p = head;
        head = head.next;
        p = null;
        return head;
    }
}
