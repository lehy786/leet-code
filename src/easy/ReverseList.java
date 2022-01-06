package easy;

public class ReverseList {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        ListNode last = null;

        while (head != null) {
            pre.next = new ListNode(head.val, last);
            last = pre.next;
            head = head.next;
        }

        return pre.next;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 0; i <5; i++) {
            ListNode node = new ListNode(i+1);
            head.next = node;
            head = node;
        }

        ListNode res = reverseList1(pre);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
