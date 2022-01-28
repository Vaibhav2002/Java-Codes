package data_structures.linkedlist.single;

public class mergeSortReverse {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            next = null;
            data = x;
        }
    }

    //utility function to print linked list
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
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    Node mergeDiv(Node head) {
        if (head == null||head.next==null)
            return head;
        Node mid = findMid(head);
        Node nextofMid = mid.next;
        mid.next = null;
        Node left = mergeDiv(head);
        Node right = mergeDiv(nextofMid);
        return mergeSortRev(left, right);

    }

    private Node mergeSortRev(Node left, Node right) {
        Node res = null, temp1 = left, temp2 = right;
        while (temp1 != null && temp2 != null) {
            if (res == null)
                res = new Node(Math.min(temp1.data, temp2.data));
            else { //rather than inserting node at last we insert add front
                Node t = new Node(Math.min(temp1.data, temp2.data));
                t.next = res;
                res = t;
            }
            if (temp1.data < temp2.data)
                temp1 = temp1.next;
            else
                temp2 = temp2.next;
        }
        if (temp1 != null) {
            Node t = temp1;
            while (temp1.next != null)
                temp1 = temp1.next;
            temp1.next = res;
            res = t;
        } else if (temp2 != null) {
            Node t2 = temp2;
            while (temp2.next != null)
                temp2 = temp2.next;
            temp2.next = res;
            res = t2;
        }
        return res;
    }

    public static void main(String[] args) {
        mergeSortReverse ob = new mergeSortReverse();
        //creating linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        System.out.println("Original List : ");
        ob.printList(head);
        head = ob.mergeDiv(head);
        System.out.println("List after sorting :");
        ob.printList(head);
    }
}
