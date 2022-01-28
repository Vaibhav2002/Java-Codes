package data_structures.linkedlist.single;

public class rotate {
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

    void rotation(Node head, int k) {
        Node temp = head;
        for (int i = 0; temp != null && i < k - 1; i++)
            temp = temp.next;
        if (temp == null) return;
        Node t = temp.next;
        temp.next = null;
        Node t1 = t;
        while (t1.next != null)
            t1 = t1.next;
        t1.next = head;
        head = t;
    }

    public static void main(String[] args) {
        rotate ob = new rotate();
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        System.out.println("Original List :");
        ob.printList(head);
        ob.rotation(head, 4);
        System.out.println("List after rotating : ");
        ob.printList(head);
    }
}
