public class LinkedListExmpl {
    private class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    Node head;

    public boolean add(int i) {
        Node curr = head;

        while (head.next) {
            curr = next;
        }
        curr.next = new Node(i, Void)


        return true;
    }

    public static void main(String[] args) {
        
    }
}
