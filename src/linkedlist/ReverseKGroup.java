package linkedlist;

public class ReverseKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode preHead = null, curHead = null, curTail = null, retHead = head;
//
//        // 记录长度、划分为几段、最后一段是否需要逆序
//        int length = 0;
//        int phase = 0;
//        while (head != null) {
//            length++;
//            if (length % k == 0) {
//                phase++;
//            }
//            head = head.next;
//        }
//        boolean lastNoNeedReverse = (phase + 1) * k > length;
//        // 恢复头节点
//        head = retHead;
//
//
//        // 逐段进行reverse
//        for (int i = 0; i <= phase; i++) {
//            if (i == phase && lastNoNeedReverse) {
//                // 最后一段
//                if (preHead != null) {
//                    preHead.next = head;
//                }
//                return retHead;
//            }
//            // 翻转链表
//            int cur = 0;
//            ListNode pre = null, next = null;
//            curHead = head;
//            while (head != null && cur < k) {
//                next = head.next;
//                head.next = pre;
//                pre = head;
//                head = next;
//                cur++;
//            }
//            curTail = pre;
//            // 第一次翻转，最后的head为整体第k个元素
//            if (i == 0) {
//                retHead = curTail;
//            }
//            if (preHead != null) {
//                preHead.next = curTail;
//            }
//            preHead = curHead;
//        }
//
//        return retHead;
//    }

    /**
     * 精简化
     */


    /**
     * 翻转链表
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        // 上一组的翻转后最后节点
        ListNode pre = fake;
        // 当前遍历到的节点，每组执行完后等同于pre
        ListNode end = fake;

        // end.next != null时代表有下一组(0, K)个元素
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return fake.next;
    }
}
