package arraycodes;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i]<dep[i-1])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={900,940,950,1100 ,1500 ,1800};
        int dep[]={910, 1200, 1120, 1130 ,1900 ,2000};
        System.out.println(findPlatform(arr,dep,arr.length));
    }
}
