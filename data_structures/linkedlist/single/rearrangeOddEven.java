package data_structures.linkedlist.single;

public class rearrangeOddEven {
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

    Node rearrange(Node head) {
        Node oddStart = new Node(0), evenStart = new Node(0); //create two dummy nodes for even list and odd list
        Node oddEnd = oddStart, evenEnd = evenStart; //create two nodes to point to end of even and odd lists
        Node temp = head;
        for (int i = 0; temp != null; temp = temp.next, i++) {
            if (i % 2 == 0) { //if node at even position assuming list starts from 0 index
                oddEnd.next = new Node(temp.data);
                oddEnd = oddEnd.next;
            } else { //if node at odd position assuming list starts from 0 index
                evenEnd.next = new Node(temp.data);
                evenEnd = evenEnd.next;
            }
        }
        //join the two lists
        head = oddStart.next;
        oddEnd.next = evenStart.next;
        evenEnd.next = null;
        return head;
    }

    public static void main(String[] args) {
        rearrangeOddEven ob = new rearrangeOddEven();
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(9);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        System.out.println("Original List : ");
        ob.printList(head);
        System.out.println("List after rearranging :");
        head = ob.rearrange(head);
        ob.printList(head);
    }
}
