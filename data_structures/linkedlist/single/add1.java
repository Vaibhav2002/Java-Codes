package data_structures.linkedlist.single;

public class add1 {
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
    //utility function to reverse linked list
    Node reverse(Node head) {
        Node pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    Node add(Node head) {
        if (head == null)
            return null;
        head = reverse(head); //reverse the list list so it becomes easy to add
        Node temp = head, prev = null; //create a temp variable to traverse list and prev to keep track of last node
        int carry = 1;
        while (temp != null && carry != 0) {
            int sum = carry + temp.data;
            carry = sum / 10;
            sum = sum % 10;
            temp.data = sum;
            prev = temp;
            temp = temp.next;
        }
        if (carry != 0 && prev != null) //if linked list ends and carry is not zero
            prev.next = new Node(carry);
        return reverse(head); //reverse linked list and return
    }

    public static void main(String[] args) {
        add1 ob = new add1();
        //creating 1st linked list
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        System.out.println("Original list : ");
        ob.printList(head);
        System.out.println("List after adding");
        head = ob.add(head);
        ob.printList(head);
    }
}
