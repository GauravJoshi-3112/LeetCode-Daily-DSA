class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, windowsum = 0, minLength = Integer.MAX_VALUE;

        while (end < nums.length) { 
            windowsum += nums[end++];
            while(start<= end && windowsum >= target) {
                minLength = Math.min(minLength,end - start);
                windowsum -= nums[start++];
            }
        } 
        return minLength != Integer.MAX_VALUE ? minLength : 0;     
    }
}