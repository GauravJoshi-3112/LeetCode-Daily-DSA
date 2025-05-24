class Solution {
    public int maxProfit(int[] prices) {
        int minElem = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if (prices[i] > minElem) {
                maxProfit = Math.max(maxProfit, prices[i] - minElem);
            } else {
                minElem = prices[i];
            }
        }

        return maxProfit;
    }
}