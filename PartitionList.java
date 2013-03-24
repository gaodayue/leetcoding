public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lpart_first ,lpart_last, rpart_first, rpart_last;
        lpart_first = lpart_last = rpart_first = rpart_last = null;

        for (ListNode cur=head; cur != null; cur=cur.next) {
            if (cur.val < x) {
                if (lpart_first == null) {
                    lpart_first = lpart_last = cur;
                } else {
                    lpart_last.next = cur;
                    lpart_last = cur;
                }
            } else {
                if (rpart_first == null) {
                    rpart_first = rpart_last = cur;
                } else {
                    rpart_last.next = cur;
                    rpart_last = cur;
                }
            }
        }
        if (rpart_last != null) {
            rpart_last.next = null;
        }

        if (lpart_last != null) {
            lpart_last.next = rpart_first;
            return lpart_first;
        }
        return rpart_first;
    }
}
