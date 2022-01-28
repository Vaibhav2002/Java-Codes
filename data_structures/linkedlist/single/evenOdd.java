package data_structures.linkedlist.single;

public class evenOdd {
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

    Node segregate(Node head) {
        Node dummyEven = new Node(0),dummyOdd = new Node(1); //create two dummy nodes
        Node evenEnd = dummyEven,oddEnd = dummyOdd; // points to end of dummy nodes
        Node temp = head; //temp for iteration
        while (temp != null) {
            if (temp.data % 2 == 0) {
                evenEnd.next = temp; //add node to dummylinked list for even
                evenEnd = evenEnd.next;//move to last node
            } else {
                oddEnd.next = temp; //add node to dummylinked list for odd
                oddEnd = oddEnd.next;//move ro last node
            }
            temp = temp.next;
        }
        Node res=dummyEven.next; //join the two linked lists
        evenEnd.next=dummyOdd.next;
        oddEnd.next=null;
        return res;
    }

    public static void main(String[] args) {
        evenOdd ob=new evenOdd();
        //creating linked list
        Node head = new Node(70);
        head.next = new Node(55);
        head.next.next = new Node(41);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(17);
        head.next.next.next.next.next = new Node(19);
        head.next.next.next.next.next.next = new Node(80);
        //creating linked list
        System.out.println("Original List :");
        ob.printList(head);
        Node res=ob.segregate(head);
        System.out.println("List after segregating even and odd : ");
        ob.printList(res);
    }
}
