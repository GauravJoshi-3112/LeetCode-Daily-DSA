class Solution {
    public int countSubarrays(int[] nums) {
        int start = 0;
        int count = 0;
        for(int end = 2; end < nums.length; end++) {
            if (2*(nums[start] + nums[end]) == nums[(start+end)/2]) count++;
            start++;
        }

        return count;
    }
}