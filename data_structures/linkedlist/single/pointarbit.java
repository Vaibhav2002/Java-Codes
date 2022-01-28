package data_structures.linkedlist.single;

public class pointarbit {
    static class Node {
        Node next, arbit;
        int data;

        Node(int x) {
            data = x;
            next = arbit = null;
        }
    }

    void printList(Node head) {
        System.out.println("data\tnext highest value");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + "\t\t" + ((temp.arbit == null) ? "null" : temp.arbit.data));
            temp = temp.next;
        }
    }

    Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node arbitify(Node head) {
        head = reverse(head); //reverse the list
        Node max = head, temp = head.next; //keep the max till now in a max variable
        while (temp != null) {
            temp.arbit = max; //link arbitary value to max node
            if (temp.data > max.data) //if the current value is greater than max value
                max = temp; //set max to that node
            temp = temp.next;
        }
        return reverse(head); //reverse the list to make it like before
    }

    public static void main(String[] args) {
        pointarbit ob = new pointarbit();
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        System.out.println("original List :");
        ob.printList(head);
        System.out.println("List after filling arbit value");
        head = ob.arbitify(head);
        ob.printList(head);
    }
}
