package data_structures.linkedlist.doubly;

import kotlin.Pair;
import java.util.ArrayList;
import java.util.Scanner;

public class PairSumCount {

    ArrayList<Pair<Integer, Integer>> findPairs(Dnode head, int target){
        Dnode last = findLastNode(head);
        Dnode start = head;
        var ans = new ArrayList<Pair<Integer, Integer>>();
        while(start != last){
            int sum = start.data+last.data;
            if(sum == target){
                ans.add(new Pair<>(last.data,start.data));
                if(start.prev == last && last.next == start)
                    break;
                start = start.prev;
                last = last.next;
            }
            else if(sum<target)
                start = start.prev;
            else
                last = last.next;
        }
        return ans;
    }

    Dnode findLastNode(Dnode head){
        Dnode temp = head;
        while(temp!=null && temp.prev !=null){
            temp = temp.prev;
        }
        return temp;
    }

    public static void main(String[] args){
        PairSumCount ob = new PairSumCount();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<2) {
            System.out.println("n must be greater than 2");
            return;
        }
        var nodes = new Dnode[n];
        for(int i=0;i<n;i++)
            nodes[i] = new Dnode(sc.nextInt());

        nodes[0].next = nodes[1];
        nodes[n-1].prev = nodes[n-2];
        for(int i=1;i<n-1;i++){
            nodes[i].next = nodes[i+1];
            nodes[i].prev = nodes[i-1];
        }

        System.out.println("Enter number to search");
        int k = sc.nextInt();

        System.out.println(ob.findPairs(nodes[0], k));

    }
}
