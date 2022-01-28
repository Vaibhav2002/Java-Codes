package data_structures.linkedlist.single;

import java.util.HashSet;

public class removeLoop {
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

    void remove(Node head) {
        if (head == null)
            return;
        HashSet<Node> ob = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (ob.contains(temp.next))
                temp.next = null;
            else {
                ob.add(temp);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        removeLoop ob = new removeLoop();
        //creating linked list
        Node head = new Node(70);
        head.next = new Node(50);
        head.next.next = new Node(50);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next = head.next;
        //creating linked list
        System.out.println("List after removing loop:");
        ob.remove(head);
        ob.printList(head);
    }
}
