class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        result[result.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            result[i] = result[i+1]*nums[i+1];
        }

        int leftP = 1;
        for(int i=0; i<result.length; i++) {
            result[i] = leftP * result[i];
            leftP = leftP * nums[i];
        }

        return result;
    }
}