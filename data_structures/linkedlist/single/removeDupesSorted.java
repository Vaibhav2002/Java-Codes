package data_structures.linkedlist.single;

public class removeDupesSorted {
    static class Node {
        Node next;
        int data;

        Node(int x) {
            data = x;
            next = null;
        }
    }
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }
    void removeDupes(Node head)
    {
        Node temp=head;
        while (temp!=null&&temp.next!=null)
        {
            Node temp1=temp.next;
            while (temp1!=null&&temp.data== temp1.data)
                temp1=temp1.next;
            temp.next=temp1;
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        removeDupesSorted ob=new removeDupesSorted();
        //creating linked list
        Node head = new Node(70);
        head.next = new Node(50);
        head.next.next = new Node(50);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next = new Node(20);
        //creating linked list
        System.out.println("Original List :");
        ob.printList(head);
        System.out.println("List after removing duplicates :");
        ob.removeDupes(head);
        ob.printList(head);
    }
}
