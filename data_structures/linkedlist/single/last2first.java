package data_structures.linkedlist.single;

public class last2first {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
    //utility function to print linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.print(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    Node move(Node head) {
        if (head == null || head.next == null) //if there is no list or only one node
            return head;
        Node temp = head;
        Node last = null; //to point to last node
        while (temp.next.next != null) //traverse till 2nd last node
            temp = temp.next;
        last = temp.next; //point last node
        temp.next = null; //move last node to first
        last.next = head;
        head = last;
        return head;
    }

    public static void main(String[] args) {
        last2first ob = new last2first();
        //creating linked list 1->2->3->4->5->6->7
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(10);
        //creating linked list
        System.out.println("Original list : ");
        ob.printList(head);
        head = ob.move(head);
        System.out.println("\nAfter moving last node to first :");
        ob.printList(head);
    }
}
