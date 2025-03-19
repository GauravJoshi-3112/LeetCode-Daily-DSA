class Solution {
    // This is a typial Unbounded KnapSack Problem 
    // How ?
    // As we have the option again to Select the Coin Once Chosen 
    int dp [][];
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        dp = new int [amount+1][coins.length+1];

        for(int i=0; i<amount+1; i++) {
            dp[i][0] = 0; // This Updation is for j = 0
        }

        for(int j=0; j<coins.length+1; j++) {
            dp[0][j] = 1;
        }

        // Initialization is DONE

        for(int i=1; i<amount+1; i++) {
            for(int j=1; j<coins.length+1; j++) {
                if (i < coins[j-1]) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] =   dp[i][j-1] + dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[amount][coins.length];
    }
}