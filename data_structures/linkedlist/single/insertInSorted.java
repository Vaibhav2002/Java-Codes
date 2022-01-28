package data_structures.linkedlist.single;

public class insertInSorted {
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
    //inserting a node with the given value in a sorted linked list
    Node insert(Node head, int x) {
        Node temp = head; //temporary pointer to head node
        Node ins = new Node(x);
        if (x < temp.data) { //if value is the smallest value make it the head node
            ins.next = temp;
            return ins;
        }
        while (temp.next != null && temp.next.data < x) //traverse util the position to insert is found
            temp = temp.next;
        ins.next = temp.next; //insert node
        temp.next = ins;
        return head;
    }

    public static void main(String[] args) {
        insertInSorted ob = new insertInSorted();
        //creating linked list 1->2->3->4->5->6->7
        Node head = new Node(-3);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(17);
        //creating linked list
        System.out.println("List :");
        ob.printList(head);
        System.out.println();
        head = ob.insert(head, 18);
        ob.printList(head);
    }
}
