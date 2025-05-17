class Solution {
    public void sortColors(int[] nums) {
        // Typical Dutch National Flag Algo Problem
        int i = 0, j = 0, k = nums.length-1;
        while (j <= k) {
            if (nums[j] == 2) {
                nums[j] = nums[k];
                nums[k] = 2;
                k--;
            } else if (nums[j] == 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                i++; 
                j++;
            } else {
                j++;
            }
        }
    }
}