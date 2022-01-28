package arraycodes;

public class ConsecutivePairSwap {
    public int[] solve(int[] nums) {
        if(nums.length<=2)
            return nums;
        int i=0,j=1;
        while(i<nums.length&&j<nums.length){
            int temp=nums[i+2];
            nums[i+2]=nums[i];
            nums[i]=temp;
            temp=nums[j+2];
            nums[j+2]=nums[j];
            nums[j]=temp;
            i+=2;
            j+=2;
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
