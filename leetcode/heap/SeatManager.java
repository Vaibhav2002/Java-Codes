package leetcode.heap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/seat-reservation-manager/">Problem</a>
**/
public class SeatManager {

    HashSet<Integer> reserved;
    int n;

    public SeatManager(int n) {
        this.n = n;
        reserved = new HashSet<>();
    }

    public int reserve() {
        for(int i=1;i<=n;i++) if(!reserved.contains(i)) {
            reserved.add(i);
            return i;
        };
        return -1;
    }

    public void unreserve(int seatNumber) {
        reserved.remove(seatNumber);
    }
}
