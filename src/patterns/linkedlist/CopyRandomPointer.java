package patterns.linkedlist;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node cur = head;

        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = cur.next;
        Node copy = copyHead;

        while (cur != null) {
            cur.next = cur.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            cur = cur.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
