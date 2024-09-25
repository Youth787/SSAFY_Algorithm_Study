class Solution {
    public int maxProfit(int[] prices) {
        
        int buyprice = prices[0];
        int profit = 0;
        if(prices.length ==1) return 0;

        for(int i=1; i<prices.length; i++){
            int diff = prices[i]-buyprice;
            if(diff>profit) profit = diff;
            if(buyprice > prices[i]) buyprice = prices[i];
        }
        return profit;   
    }
}
