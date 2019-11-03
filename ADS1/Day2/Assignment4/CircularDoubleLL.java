class Node {
    int value;
    Node next;
    Node prev;

    Node(int val) {
        this.value = val;
    }
}

class circularDouble {
    Node head;
    Node tail;

    public void add(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void formCircle() {
        tail.next = head;
        head.prev = tail;
    }
}
