class Solution {
    int [][] dp;
    public int minPathSum(int[][] grid) {
        // Creating dp Array
        int m = grid.length; // Rows
        int n = grid[0].length; // Colunm
        dp = new int [m][n];
        dp[0][0] = grid[0][0]; // Initializing dp Array

        // Initilizing first col of every row
        for(int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Initilizing first row of every col
        for(int j=1; j<n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Calculating Min Path Sum
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}