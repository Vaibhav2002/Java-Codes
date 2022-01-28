package data_structures.linkedlist.single;

public class mergeList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //utility funtion to print liked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.print(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    Node merge(Node head1, Node head2) {
        Node dummy = new Node(0); //dummy node to act as head node
        Node temp = dummy; //temporary node to point at head node
        while (head1 != null && head2 != null) { //until any list finishes
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next; //move to next node
        }
        if (head1 == null)  //if 1st linked list runs out join the 2nd remaining list
            temp.next = head2;
        else
            temp.next = head1; //if 2ns linked list runs out join the 1st remaining list
        return dummy.next;
    }

    //merging the two list recursively
    Node mergeRecur(Node head1, Node head2) {
        if (head1 == null) //if 1st linked list runs out join the 2nd remaining list
            return head2;
        else if (head2 == null) //if 2nd linked list runs out join the 1st remaining list
            return head1;
        if (head1.data <= head2.data) {
            head1.next = mergeRecur(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeRecur(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        mergeList ob = new mergeList();
        //creating 1st linked list 2->4->6->8->10->12->14
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next = new Node(14);
        //creating 1st linked list

        //creating 2nd linked list 1->3->5->7->9->11->13
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(9);
        head2.next.next.next.next.next = new Node(11);
        head2.next.next.next.next.next.next = new Node(13);
        //creating 2nd linked list

        System.out.println("List 1 :");
        ob.printList(head);
        System.out.println("\nList 2 :");
        ob.printList(head2);
        System.out.println("\nmerged list :");
        Node newhead = ob.merge(head, head2);
        ob.printList(newhead);
    }
}
