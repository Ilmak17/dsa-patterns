package patterns.linkedlist;

class DoublyLinkedList {
    int key;
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}