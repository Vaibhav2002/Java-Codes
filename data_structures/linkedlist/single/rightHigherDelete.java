package data_structures.linkedlist.single;

public class rightHigherDelete {
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

    void delete(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data > temp.data) {
                temp.data = temp.next.data;
                temp.next = temp.next.next;
            } else temp = temp.next;
        }
    }

    public static void main(String[] args) {
        rightHigherDelete ob = new rightHigherDelete();
        //creating linked list
        Node head = new Node(70);
        head.next = new Node(60);
        head.next.next = new Node(50);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next = new Node(10);
        // creating linked list
        System.out.println("List :");
        ob.printList(head);
        ob.delete(head);
        System.out.println("List after deleting :");
        ob.printList(head);
    }
}
