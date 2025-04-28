class Solution {
    public int findTargetSumWaysH(int [] nums, int index, int target, int currSum) {
        if (index == nums.length) return target == currSum ? 1 : 0;
        else return findTargetSumWaysH(nums, index+1, target, currSum+nums[index]) + findTargetSumWaysH(nums, index+1, target, currSum-nums[index]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysH(nums, 0, target, 0);
    }
}