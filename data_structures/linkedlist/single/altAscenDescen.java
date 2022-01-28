package data_structures.linkedlist.single;

public class altAscenDescen {
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

    Node sort(Node head) {
        Node dumAsc = new Node(0), dumDesc = new Node(0);
        Node ascEnd = dumAsc, descEnd = dumDesc;
        Node temp = head;
        while (temp != null) {
            ascEnd.next = temp;
            ascEnd = ascEnd.next;
            temp = temp.next;
            if (temp != null) {
                descEnd.next = temp;
                descEnd = descEnd.next;
                temp = temp.next;
            }
            descEnd.next = null;
            ascEnd.next = null;
        }
        dumAsc = dumAsc.next;
        dumDesc = dumDesc.next;
        dumDesc = reverse(dumDesc);
        return merge(dumAsc, dumDesc);
    }

    private Node reverse(Node dumDesc) {
        Node prev = null, curr = dumDesc, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private Node merge(Node dumAsc, Node dumDesc) {
        if (dumAsc == null)
            return dumDesc;
        if (dumDesc == null)
            return dumAsc;
        Node temp;
        if (dumAsc.data < dumDesc.data) {
            temp = dumAsc;
            temp.next = merge(dumAsc.next, dumDesc);
        } else {
            temp = dumDesc;
            temp.next = merge(dumAsc, dumDesc.next);
        }
        return temp;
    }

    public static void main(String[] args) {
        altAscenDescen ob = new altAscenDescen();
        Node head = new Node(10);
        head.next = new Node(40);
        head.next.next = new Node(53);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(67);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(89);
        System.out.println("Original List :");
        ob.printList(head);
        head = ob.sort(head);
        System.out.println("Sorted List : ");
        ob.printList(head);
    }
}
