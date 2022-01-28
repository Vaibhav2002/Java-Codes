package dsaSprint;


/**
 * Very very important problem , must prepare.
 * Tortoise and hare algorithm is used in this problem.
 * Tortoise and hare algo is also used in Floyd's Cycle detection algo and many more important problems
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int hare = 0, tor = 0;
        do {
            tor = nums[tor];
            hare = nums[nums[hare]];
        } while (hare != tor);
        tor = 0;
        while (tor != hare) {
            tor = nums[tor];
            hare = nums[hare];
        }
        return tor;
    }

    //revision
    public static int findDuplicateValue(int[] a) {
        int tor = 0, hare = 0;
        do {
            tor = a[tor];
            hare = a[a[hare]];
        } while (tor != hare);
        tor = 0;
        while(tor!=hare){
            tor = a[tor];
            hare = a[hare];
        }
        return tor;

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateValue(a));
    }
}
