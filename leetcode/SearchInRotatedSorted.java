package leetcode;

import java.util.Arrays;

public class SearchInRotatedSorted {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans;
        if(pivot==-1)
            ans= Arrays.binarySearch(nums,0,nums.length,target);
        else if (target >= nums[0])
            ans = Arrays.binarySearch(nums, 0, pivot, target);
        else
            ans = Arrays.binarySearch(nums, pivot, nums.length, target);
        return ans < 0 ? -1 : ans;


    }

    int findPivot(int[] a) {
        int l = 0, u = a.length;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if (mid < a.length - 1 && a[mid] > a[mid + 1])
                return mid + 1;
            if (mid > 0 && a[mid] < a[mid - 1])
                return mid;
            if (a[mid] > a[l])
                l = mid + 1;
            else
                u = mid - 1;
        }
        return -1;
    }



    public int searchVal(int[] nums, int target) {
        int pivot = findPivot2(nums);
        if(pivot == -1)
            return searchInRange(nums, 0, nums.length-1, target);
        else if(target>=nums[0])
            return searchInRange(nums, 0, pivot, target);
        else
            return searchInRange(nums, pivot+1, nums.length-1, target);

    }

    int findPivot2(int[] a){
        int l=0,u=a.length-1;
        while(l<=u){
            int mid = l+(u-l)/2;
            if(mid<a.length-1 && a[mid+1]<a[mid])
                return mid+1;
            if(mid>0 && a[mid-1]>a[mid])
                return mid;
            else if(a[mid]>a[0])
                l = mid+1;
            else
                u = mid-1;
        }
        return -1;

    }

    int searchInRange(int[] a, int l , int u, int target){
        while(l<=u){
            int mid = l+(u-l)/2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] < target)
                l = mid+1;
            else
                u = mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSorted ob = new SearchInRotatedSorted();
        System.out.println(ob.searchVal(new int[]{8,9,2,3,4}, 9));
    }
}
