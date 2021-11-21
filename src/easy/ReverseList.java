package easy;

/**
 * Created by luozhenzhao on 2021/9/3
 * description:
 */
public class ReverseList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode next, tail = null;
        while (head != null) {
            next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
