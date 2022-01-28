package dsaSprint;

public class StockBuySellProfit {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,ans = 0;
        for(int i:prices){
            minPrice = Math.min(minPrice,i);
            ans = Math.max(i-minPrice,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        System.out.println(maxProfit(a));
    }
}
