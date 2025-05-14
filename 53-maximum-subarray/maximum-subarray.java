class Solution {
    public int maxSubArray(int[] nums) {
        int targetSum = nums[0], currSum = nums[0];
        for(int i=1; i<nums.length; i++) {
            currSum = Math.max(currSum+nums[i], nums[i]);
            targetSum = Math.max(currSum,targetSum);
        }
        return targetSum;
    }
}