package data_structures.linkedlist.single;

public class deleteLastOccur {
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

    void delete(Node head, int k) {
        Node temp = head;
        Node prev = null, ptr = null;
        while (temp.next != null) {
            if (temp.next.next == null)
                prev = temp;
            if (temp.data == k)
                ptr = temp;
            temp = temp.next;
        }
        if (temp.data == k) {
            prev.next = null;
        } else if (ptr.next != null) {
            ptr.data = ptr.next.data;
            ptr.next = ptr.next.next;
        }
    }

    public static void main(String[] args) {
        deleteLastOccur ob = new deleteLastOccur();
        //creating 1st linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(20);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        System.out.println("Original list : ");
        ob.printList(head);
        System.out.println("List after deleting");
        ob.delete(head, 20);
        ob.printList(head);
    }
}
