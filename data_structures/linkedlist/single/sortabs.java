package data_structures.linkedlist.single;

public class sortabs {
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

    Node sort(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data > temp.next.data) {
                Node ext = temp.next;
                temp.next = temp.next.next;
                ext.next = head;
                head = ext;
            } else
                temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        sortabs ob = new sortabs();
        Node head = new Node(1);
        head.next = new Node(-2);
        head.next.next = new Node(-5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(-9);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(-15);
        System.out.println("Original List : ");
        ob.printList(head);
        head = ob.sort(head);
        System.out.println("List after sorting : ");
        ob.printList(head);
    }
}
