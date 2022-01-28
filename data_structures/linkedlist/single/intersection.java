package data_structures.linkedlist.single;

public class intersection {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            next = null;
            data = x;
        }
    }
    //utility function to print lists
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }
    //utility function to find size of the linked list
    int getCount(Node head) {
        int c = 0;
        Node temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
    //wrapper function for intersect() with first Node parameter as the larger list and second as smaller list
    int Intersectionpoint(Node head1, Node head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        if (c1 > c2)
            return intersect(head1, head2, c1, c2);
        else return intersect(head2, head1, c2, c1);
    }

    int intersect(Node head1, Node head2, int c1, int c2) {
        int c = c1 - c2; //find difference in lengths
        Node temp1 = head1, temp2 = head2;
        for (int i = 0; i < c; i++) //traverse to cth node of the larger list
            temp1 = temp1.next;
        while (temp1 != null && temp2 != null) { //traverse both lists simultaneously as both have now same length
            if (temp1 == temp2) //if value of the two node objects are same it means they are intersecting
                return temp1.data;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return Integer.MAX_VALUE; //if there is no intersection point
    }

    public static void main(String[] args) {
        intersection ob = new intersection();
        //creating 1st linked list
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(20);
        //creating 1st linked list
        //creating 2nd linked list
        Node head2 = new Node(7);
        head2.next = new Node(34);
        head2.next.next = new Node(4);
        //creating 2nd linked list
        System.out.println("First list :");
        ob.printList(head);
        System.out.println("Second list :");
        ob.printList(head2);
        int val = ob.Intersectionpoint(head, head2);
        System.out.println((val == Integer.MAX_VALUE) ? "No intersection point" : "Intersection at " + val);
    }
}
