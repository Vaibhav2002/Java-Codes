package data_structures.linkedlist.single;

public class setOperations {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }
    Node intersect(Node head1,Node head2)
    {
        return null;
    }
}
