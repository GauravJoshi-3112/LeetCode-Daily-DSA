class Solution {
    int [] dp;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0],nums[1]);
        dp = new int [nums.length];
        // Initializing dp array
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for(int i=3; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
        }

        return Math.max(dp[dp.length-1],dp[dp.length-2]);
        
    }
}