package data_structures.linkedlist.single;


/*
 * This solution checks if linkedList is Palindrome in O(N) time and O(1) space
 */
public class LinkedListPalin {

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

    boolean isPalindrome(Node head) {
        if (head.next == null)
            return true;
        int len = findLength(head);
        Node middle = findMiddle(head);
        Node first = head;
        Node second = null;
        Node temp = head;
        while (temp.next != middle) temp = temp.next;
        if (len % 2 == 0)
            second = temp.next;
        else
            second = temp.next.next;
        temp.next = null;
        second = rev(second);
        boolean isEquals = checkEquals(first, second);
        second = rev(second);
        if (len % 2 == 0)
            temp.next = second;
        else
            temp.next = middle;
        return isEquals;
    }

    boolean checkEquals(Node head1, Node head2) {
        Node temp = head1, temp2 = head2;
        while (temp != null && temp2 != null) {
            if (temp.data != temp2.data)
                return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return temp == temp2;
    }

    Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node rev(Node head) {
        Node curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    int findLength(Node head) {
        if (head == null)
            return 0;
        return 1 + findLength(head.next);
    }

    public static void main(String[] args) {
        LinkedListPalin ob = new LinkedListPalin();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next= new Node(1);
        ob.printList(head);
        System.out.println(ob.isPalindrome(head));
        ob.printList(head);

    }
}
