package data_structures.linkedlist.single;

public class pairwiseSwap {
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

    void swap(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            int tempo = temp.data;
            temp.data = temp.next.data;
            temp.next.data = tempo;
            temp = temp.next.next;
        }
    }

    public static void main(String[] args) {
        pairwiseSwap ob = new pairwiseSwap();
        //creating linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        //creating linked list
        System.out.println("List :");
        ob.printList(head);
        System.out.println("List after swapping : ");
        ob.swap(head);
        ob.printList(head);
    }
}
