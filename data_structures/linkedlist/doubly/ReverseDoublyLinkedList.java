package data_structures.linkedlist.doubly;

import java.util.Scanner;

public class ReverseDoublyLinkedList {
    public static Dnode reverseDLL(Dnode head) {
        if (head == null)
            return null;
        Dnode last = findLast(head);
        Dnode start = head;
        while (start != last) {

            Dnode nextNode = start.next;
            Dnode prevNode = last.prev;
            Dnode temp = last.prev;
            last.prev = start.prev;
            start.prev = temp;
            temp = last.next;
            last.next = start.next;
            start.next = temp;

            if(last.prev == null)
                head = last;

            if(last.next == start && start.prev == last)
                break;

            start = nextNode;
            last = prevNode;
        }
        return head;
    }


    static Dnode findLast(Dnode head) {
        Dnode temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    static void printList(Dnode head) {
        Dnode temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var nodes = new Dnode[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Dnode(sc.nextInt());

        nodes[0].next = nodes[1];
        nodes[n - 1].prev = nodes[n - 2];
        for (int i = 1; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i].prev = nodes[i - 1];
        }

        Dnode revList = reverseDLL(nodes[0]);
        printList(revList);

    }

}
