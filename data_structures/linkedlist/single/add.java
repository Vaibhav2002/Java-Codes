package data_structures.linkedlist.single;

public class add {
    static class Node {
        Node next;
        int data;

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

    Node addition(Node head1, Node head2) {
        Node res = new Node(0);
        Node end = res;
        int carry = 0, sum = 0;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null)
                sum = temp2.data + carry;
            else if (temp2 == null)
                sum = temp1.data + carry;
            else
                sum = temp1.data + temp2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            end.next = new Node(sum);
            end = end.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if(carry!=0)
            end.next=new Node(carry);
        return res.next;
    }



    Node addTwoLists(Node first, Node second){
        first = rev(first);
        second = rev(second);
        int carry =0;
        Node dummy = new Node(0);
        Node dTemp = dummy;
        Node temp1 = first,temp2 = second;
        while(temp1!=null && temp2!=null){
            int sum = carry + temp1.data+temp2.data;
            carry = sum/10;
            sum = sum%10;
            dTemp.next = new Node(sum);
            dTemp = dTemp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1!=null){
            temp1.data = temp1.data + carry;
            dTemp.next = temp1;
        }
        else if(temp2!=null){
            temp2.data = temp2.data + carry;
            dTemp.next = temp2;
        }
        dummy = dummy.next;
        dummy = rev(dummy);
        return dummy;

    }


     Node rev(Node head){
        if(head == null)
            return null;
        Node curr = head, prev = null, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        add ob = new add();
        //creating 1st linked list
        Node head = new Node(4);
        head.next = new Node(5);
        //creating 1st linked list
        //creating 2nd linked list
        Node head2 = new Node(3);
        head2.next = new Node(4);
        head2.next.next = new Node(5);
        //creating 2nd linked list
        System.out.println("First list :");
        ob.printList(head);
        System.out.println("2nd List : ");
        ob.printList(head2);
        Node res = ob.addTwoLists(head, head2);
        System.out.println("Sum List : ");
        ob.printList(res);
    }
}
