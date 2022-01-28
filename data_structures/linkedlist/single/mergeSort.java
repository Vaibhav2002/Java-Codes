package data_structures.linkedlist.single;

public class mergeSort {
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

    Node findMid(Node head) {
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node mergeDiv(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = findMid(head);
        Node next2head = mid.next;
        mid.next = null;
        Node left = mergeDiv(head);
        Node right = mergeDiv(next2head);
        return merge(left, right);
    }

    Node merge(Node left, Node right) {
        Node res;
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.data < right.data) {
            res = left;
            res.next = merge(left.next, right);
        } else {
            res = right;
            res.next = merge(left, right.next);
        }
        return res;
    }

    public static void main(String[] args) {
        mergeSort ob = new mergeSort();
        //creating 1st linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        //creating 1st linked list
        System.out.println("Original list : ");
        ob.printList(head);
        head = ob.mergeDiv(head);
        System.out.println("Sorted list : ");
        ob.printList(head);
    }
}
