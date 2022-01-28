package data_structures.linkedlist.single;

import java.util.Scanner;

public class nthNodefromLast {
    static class Node {
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
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    void printNthnodefromLast(Node head, int n) {
        if (head == null) //check if list exists or not
            return;
        Node fast = head, slow = head;
        for (int i = 0; i < n; i++) { //move the fast pointer to nth node from beginning
            fast = fast.next;
            if (fast == null) { //if anytime fast equals null it means n is greater than list size
                System.out.println("N is greater than the size of the list");
                return;
            }
        }
        while (fast != null) { //traverse till fast pointer becomes null and move slow pointer
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.data); //slow pointer is the nth node from last
    }

    public static void main(String[] args) {
        nthNodefromLast ob = new nthNodefromLast();
        Scanner sc = new Scanner(System.in);
        //creating list 0->1->3->7->1->0
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        //creating list 0->1->3->7->1->0
        ob.printList(head);
        System.out.println("Enter value of n"); //reading value of n
        int n = sc.nextInt();
        System.out.print("Nth node from last : ");
        ob.printNthnodefromLast(head, n);
    }
}
