package data_structures.linkedlist.single;

public class swapNodes {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + "--> ");
            else
                System.out.print(temp.data);
            temp = temp.next;
        }
    }

    Node swap(Node head, int x, int y) {
        if (x == y)
            return head;
        Node a = null, b = null;
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == x)
                a = temp;
            else if (temp.next.data == y)
                b = temp;
            temp = temp.next;
        }
        if (a != null && b != null) {
            Node t1 = a.next;
            a.next = b.next;
            b.next = t1;
            t1 = a.next.next;
            a.next.next = b.next.next;
            b.next.next = t1;
        }
        return head;
    }

    public static void main(String[] args) {
        swapNodes ob = new swapNodes();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        System.out.println("List before swapping :");
        ob.print(head);
        head = ob.swap(head, 1, 8);
        System.out.println("\nList after swapping :");
        ob.print(head);
    }
}
