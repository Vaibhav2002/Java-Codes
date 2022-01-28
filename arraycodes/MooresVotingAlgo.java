package arraycodes;

/*
 * This is Moore's Voting algo , it finds the majority element in O(N) time and O(1) space
 * Majority element is the element that appears more than half of the array's size
 */
public class MooresVotingAlgo {
    /*
     * This method first calls findCandidate to find out the possible majority element
     * Then iterates through array and counts its frequency
     * If the resulting frequency is greater than size/2
     * this means that it is the majority element that we need
     * return the majority element if majority element was found
     * else return -1 to denote no majority element found
     *
     */
    static int majorityElement(int a[], int size) {
        int count = 0;
        int can = findCandidate(a, size);
        for (int i : a) {
            if (i == a[can])
                count++;
        }
        return count > size / 2 ? count : -1;
    }

    /*
     * This methods find a candidate that might be the majority element
     * We need to have 2 varibales to store index of the possible majority element and its count
     * initialize it with 0 and 1 respectively
     * Iterate through array and check if current element equals majority , then increase count
     * else decrease count
     * If at any time count is 0 , make the current element as majority and reset count to 1
     * after loop return index of majority element
     */
    static int findCandidate(int a[], int n) {
        int maj_ind = 0, count = 1;
        for (int i = 1; i < n; i++) {
            if (a[maj_ind] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_ind = i;
                count = 1;
            }
        }
        return maj_ind;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 1, 3, 3, 2}, 5));
    }
}
