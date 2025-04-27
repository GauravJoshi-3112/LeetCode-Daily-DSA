class Solution {
    int dp [];

    public int climbStairs(int n) {
        dp = new int [n+1];
        return climbStairsH(n);
    }
    public int climbStairsH(int n) {
        if (n <= 0) return 0;
        else if (n <= 2) return n;
        else {
            int way1 = dp[n-1] == 0 ? climbStairsH(n-1) : dp[n-1];
            int way2 = dp[n-2] == 0 ? climbStairsH(n-2) : dp[n-2];
            dp[n] =  way1 + way2;
            return way1 + way2;
        }
    }
}