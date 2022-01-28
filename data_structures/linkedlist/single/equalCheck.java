package data_structures.linkedlist.single;

public class equalCheck {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            next = null;
            data = x;
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

    boolean checkEqual(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == temp2;
    }

    public static void main(String[] args) {
        equalCheck ob = new equalCheck();
        //creating 1st linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        //creating 1st linked list
        //creating 2nd linked list
        Node head2 = new Node(0);
        head2.next = new Node(1);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(1);
        head2.next.next.next.next.next = new Node(0);
        //creating 2nd linked list
        System.out.println("First list :");
        ob.printList(head);
        System.out.println("Second list :");
        ob.printList(head2);
        System.out.println((ob.checkEqual(head, head2)) ? "Lists are same" : "Lists are different");
    }
}
