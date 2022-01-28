package data_structures.linkedlist.single;

public class revPrint {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.print(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    void printRev(Node head) {
        if (head == null) return;
        printRev(head.next);
        System.out.print(head.data + "-->");
    }

    public static void main(String[] args) {
        revPrint ob = new revPrint();
        //creating linked list 0->1->3->5->7->10->17
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(17);
        //creating linked list 0->1->3->5->7->10->17
        System.out.println("List :");
        ob.printList(head);
        System.out.println("\nReversed list");
        ob.printRev(head);
    }
}
