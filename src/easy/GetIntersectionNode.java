package easy;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA, pb = headB;
        int lena = 0, lenb = 0;
        while (pa != null) {
            pa = pa.next;
            lena++;
        }

        while (pb != null) {
            pb = pb.next;
            lenb++;
        }

        int commonTailLen = Math.abs(lena - lenb);
        pa = headA;
        pb = headB;
        for (int i = 0; i < commonTailLen; i++) {
            if (lena > lenb) {
                pa = pa.next;
            } else {
                pb = pb.next;
            }
        }

        while (pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pb;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
