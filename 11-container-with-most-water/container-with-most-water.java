class Solution {
    public int maxWater = 0;
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxWater = Math.max(maxWater, (j - i)*Math.min(height[i],height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}