package data_structures.linkedlist.single;

import java.util.HashSet;

public class UnionIntersection {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
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

    Node Union(Node head1, Node head2) {
        HashSet<Integer> ob = new HashSet<>();
        Node res = new Node(0), resEnd = res;
        Node temp = head1, temp2 = head2;
        while (temp != null || temp2 != null) {
            if (temp != null) {
                ob.add(temp.data);
                temp = temp.next;
            }
            if (temp2 != null) {
                ob.add(temp2.data);
                temp2 = temp2.next;
            }
        }
        for (int i : ob) {
            resEnd.next = new Node(i);
            resEnd = resEnd.next;
        }
        return res.next;
    }

    Node Intersect(Node head1, Node head2) {
        HashSet<Integer> ob = new HashSet<>();
        Node res = new Node(0), resEnd = res;
        Node temp = head1;
        while (temp != null) {
            ob.add(temp.data);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            if (ob.contains(temp.data)) {
                resEnd.next = new Node(temp.data);
                resEnd = resEnd.next;
            }
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        UnionIntersection ob = new UnionIntersection();
        //creating 1st linked list 2->4->6->8->10->12->14
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(14);
        //creating 1st linked list

        //creating 2nd linked list 1->3->5->7->9->11->13
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(11);
        head2.next.next.next.next.next.next = new Node(14);

        System.out.println("First List");
        ob.printList(head);
        System.out.println("Second List");
        ob.printList(head2);
        //creating 2nd linked list
        Node in = ob.Intersect(head, head2);
        Node un = ob.Union(head, head2);
        System.out.println("union List");
        ob.printList(un);
        System.out.println("Intersection List");
        ob.printList(in);
    }
}
