package data_structures.linkedlist.single;


import kotlin.Pair;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SwapKthFromFrontAndLast {

    public Node swapNodes(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = getLength(head);
        if(len%2==1&&k==len/2+1)
            return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        var nodesToBeAdded = remove(dummy, k, len);
        int c =0;
        Node temp = dummy;
        while(temp!=null){
            if(c==k-1){
                nodesToBeAdded.getSecond().next = temp.next;
                temp.next = nodesToBeAdded.getSecond();
            }
            else if(c == len-k){
                nodesToBeAdded.getFirst().next = temp.next;
                temp.next = nodesToBeAdded.getFirst();
            }
            c++;
            temp = temp.next;
        }
        return dummy.next;

    }

    public int getLength(Node head) {
        if (head == null)
            return 0;
        return 1 + getLength(head.next);
    }

    public Pair<Node, Node> remove(Node head, int index, int length) {
        int c = 0;
        Node temp = head;
        Node first = null, last = null;
        while (temp != null) {
            if (c == index - 1)
                first = remNode(temp);
            else if (c == length - index)
                last = remNode(temp);
            else
                temp = temp.next;
            c++;
        }
        return new Pair<>(first, last);
    }

    public Node remNode(Node temp) {
        Node toBeDeleted = temp.next;
        temp.next = temp.next.next;
        toBeDeleted.next = null;
        return toBeDeleted;
    }

    void printList(Node head) {
        var temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SwapKthFromFrontAndLast ob = new SwapKthFromFrontAndLast();
        LinkedHashMap map = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size");
        int n = sc.nextInt();
        var head = new Node(0);
        var temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        System.out.println("Enter k");
        int k = sc.nextInt();
        head = ob.swapNodes(head.next, k);
        ob.printList(head);
    }
}
