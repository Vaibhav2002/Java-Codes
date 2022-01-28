package data_structures.linkedlist.single;

import java.util.Scanner;

public class MergeSortLinkedList {

    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        var mid = findMid(head);
        var rightList = mid.next;
        mid.next = null;
        var left = mergeSort(head);
        var right = mergeSort(rightList);
        return merge(left, right);
    }

    static Node findMid(Node head) {
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node first, Node second) {
        var dummy = new Node(0);
        var dummyEnd = dummy;
        var temp1 = first;
        var temp2 = second;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                dummyEnd.next = new Node(temp1.data);
                temp1 = temp1.next;
            } else {
                dummyEnd.next = new Node(temp2.data);
                temp2 = temp2.next;
            }
            dummyEnd = dummyEnd.next;
        }
        if (temp1 != null)
            dummyEnd.next = temp1;
        else
            dummyEnd.next = temp2;
        return dummy.next;
    }

    static void printList(Node head) {
        var temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size");
        int n = sc.nextInt();
        var head = new Node(0);
        var temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        head = mergeSort(head.next);
        printList(head);
    }
}
