package mid;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luozhenzhao on 2021/9/27
 * description: least recently used
 */
public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> value;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        value = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!value.containsKey(key)) {
            return -1;
        }
        Node cur = value.get(key);
        Node pre = cur.pre;
        Node next = cur.next;
        if (pre == null && next == null) {
            return cur.value;
        }
        //.........................
        if (pre != null && next != null) {
            // node in the middle of linked list
            next.pre = pre;
            pre.next = next;
        } else if (pre == null) {
            // current node is head
            next.pre = null;
            head = head.next;
        }
        // current node is tail
        cur.pre = tail;
        cur.next = null;
        tail.next = cur;
        tail = cur;
        return cur.value;
    }

    public void put(int key, int value) {
        if (this.value.containsKey(key)) {
            get(key);
            this.value.put(key, tail);
            this.value.get(key).value = value;
            return;
        }

        // append the new node after the tail
        Node node = new Node(key, value);
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
        } else {
            head = node;
        }
        tail = node;

        // need remove eldest node
        if (this.value.size() >= this.capacity) {
            this.value.remove(head.key);
            head = head.next;
            head.pre.next = null;
            head.pre = null;
        }
        this.value.put(key, tail);
    }

    static class Node {
        Node pre;
        Node next;
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
