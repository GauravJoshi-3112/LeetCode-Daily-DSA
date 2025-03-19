class Solution {
    int [][] dp;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        dp = new int [amount+1][coins.length+1];
        
        for(int i=0; i<amount+1; i++) {
            dp[i][0] = Integer.MAX_VALUE - 1; // This Updation is for j = 0
        }


        for(int j=0; j<coins.length+1; j++) {
            dp[0][j] = 0;
        }

        
        // Initialization is DONE

        for(int i=1; i<amount+1; i++) {
            for(int j=1; j<coins.length+1; j++) {
                if (i < coins[j-1]) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-coins[j-1]][j]+1);
                }
            }
        }
        return dp[amount][coins.length] == Integer.MAX_VALUE - 1 ? -1 : dp[amount][coins.length];
    }
}