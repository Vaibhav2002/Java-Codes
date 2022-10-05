package gfg.heap;

import data_structures.linkedlist.single.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    Node mergeKList(Node[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node n)->n.data));
        Node dummy = new Node(0);
        Node dummyEnd = dummy;
        pq.addAll(Arrays.asList(arr));
        while(!pq.isEmpty()){
            var node = pq.poll();
            if(node.next!=null) pq.add(node.next);
            dummyEnd.next = node;
            dummyEnd = dummyEnd.next;
        }
        return dummy.next;
    }
}
