class Solution {
    int sum = 0;
    boolean [][] dp = null;
    public boolean canPartition(int[] nums) {
        sum = Arrays.stream(nums).sum();

        if (sum%2 != 0) return false;
        int targetSum = sum/2;

        // Initializating DP Arrray
        dp = new boolean [nums.length+1][targetSum + 1];
        for(int j=0; j<targetSum+1; j++) {
            dp[0][j] = false;
        }
        for(int i=0; i<nums.length+1; i++) {
            dp[i][0] = true;
        }
        for(int i=1; i<nums.length+1; i++) {
            for(int j=1; j<targetSum+1; j++) {
                // Two Condition
                if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}