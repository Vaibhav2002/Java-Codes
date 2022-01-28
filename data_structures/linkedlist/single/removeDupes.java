package data_structures.linkedlist.single;

import java.util.HashMap;
import java.util.HashSet;

public class removeDupes {
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
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    void removeDup(Node head) {
        Node temp = head;
        HashSet<Integer> hashset = new HashSet<>();
        hashset.add(temp.data);
        while (temp.next != null) {
            if (hashset.contains(temp.next.data))
                temp.next = temp.next.next;
            else {
                hashset.add(temp.next.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        removeDupes ob = new removeDupes();
        //creating linked list 0->1->3->5->7->10->17
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(3);
        //creating linked list 0->1->3->5->7->10->17
        System.out.println("List :");
        ob.printList(head);
        ob.removeDup(head);
        System.out.println("list after removing dupes");
        ob.printList(head);
    }
}
