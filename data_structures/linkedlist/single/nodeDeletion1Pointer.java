package data_structures.linkedlist.single;

public class nodeDeletion1Pointer {
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

    void delete(Node x) {
        x.data = x.next.data; //copy data of next node in the given node
        x.next = x.next.next; //delete next node
    }

    public static void main(String[] args) {
        nodeDeletion1Pointer ob = new nodeDeletion1Pointer();
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
        ob.delete(head.next.next.next.next);
        System.out.println("\nList after deleting : ");
        ob.printList(head);
    }
}
