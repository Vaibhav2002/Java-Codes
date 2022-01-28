package data_structures.linkedlist.single;

import java.util.Stack;

/*
 * This solution checks if linkedList is Palindrome in O(N) time and O(N) space
 */
public class checkPalin {
    static class Node {
        int data;
        Node next;

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

    boolean checkPalin(Node head) {
        Stack<Integer> stack = new Stack<>(); //create a stack to store data
        Node temp = head;
        while (temp != null) { //traverse through list and push data
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) { //traverse again
            if (temp.data != stack.pop()) //check if popped data != list data , then return false
                return false;
            temp = temp.next;
        }
        return true;
    }


    public static void main(String[] args) {
        checkPalin ob = new checkPalin();
        //creating linked list
        Node head = new Node(1);
        //creating linked list
        System.out.println("List :");
        ob.printList(head);
        System.out.println(ob.checkPalin(head) ? "Palindrome" : "Not palindrome");
    }
}
