package data_structures.linkedlist.single;

import java.util.Scanner;

public class RevInRange {

    public Node reverseBetween(Node head, int left, int right) {
        if(head == null || left == right)
            return head;
        Node start = null, end = null;
        Node pred = null;
        Node temp = head;
        int i = 0;
        while(temp!=null){
            ++i;
            if(i==left-1)
                pred = temp;
            else if(i==left)
                start = temp;
            else if(i == right){
                end = temp;
                break;
            }
            temp = temp.next;
        }
        Node revHead = reverse(start, end);
        if(pred == null)
            head = pred;
        else
            pred.next = revHead;
        return head;
    }
    public Node reverse(Node head, Node end){
        Node curr = head, prev = end.next, next = null;
        while(curr!=end.next){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        var temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RevInRange ob = new RevInRange();
        System.out.println("Enter size");
        int n = sc.nextInt();
        var head = new Node(0);
        var temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        System.out.println("Enter left and right");
        int left = sc.nextInt(), right = sc.nextInt();
        head = ob.reverseBetween(head.next, left, right);
        printList(head);
    }
}
