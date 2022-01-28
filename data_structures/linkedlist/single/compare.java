package data_structures.linkedlist.single;

public class compare {
    static class Node {
        Node next;
        char data;

        Node(char x) {
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

    int compareList(Node head1, Node head2) {
        Node temp = head1, temp2 = head2;
        while (temp != null && temp2 != null && temp.data == temp2.data) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        if (temp != null && temp2 != null)
            return (temp.data > temp2.data) ? 1 : -1;
        else if (temp != null)
            return 1;
        else if (temp2 != null)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        compare ob = new compare();
        Node head = new Node('g');
        head.next = new Node('e');
        head.next.next = new Node('E');
        head.next.next.next = new Node('k');
        Node head2 = new Node('g');
        head2.next = new Node('e');
        head2.next.next = new Node('e');
        head2.next.next.next = new Node('k');
        System.out.println("First list :");
        ob.printList(head);
        System.out.println("Second list :");
        ob.printList(head2);
        System.out.println(ob.compareList(head, head2));
    }
}
