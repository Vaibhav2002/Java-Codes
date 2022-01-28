package data_structures.linkedlist.single;

public class middleNode {
    static class Node { //static as the class in an inner class
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    //utility function to print the linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + "--> ");
            else
                System.out.print(temp.data);
            temp = temp.next;
        }
    }

    //function to find middle node
    Node find(Node head) {
        if (head == null) //if no linked list
            return null;
        Node x = head, y = head;
        while (y != null && y.next != null) { //as y becomes null the middle node will be pointed by x
            x = x.next; // move to next node
            y = y.next.next; //move to next of next node
        }
        return x;
    }

    public static void main(String[] args) {
        middleNode ob = new middleNode();
        //creating linked list 1->2->3->4->5->6->7
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        //creating linked list
        System.out.println("List :");
        ob.printList(head);
        System.out.println("\nMiddle node : " + ob.find(head).data);
    }

}
