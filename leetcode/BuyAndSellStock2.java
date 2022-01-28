package leetcode;

public class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                ans+=prices[i-1]-prices[i];
        }
        return ans;
    }
}
