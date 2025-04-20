class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length-1;
        int lh = 0, rh = 0;
        int trappedWater = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] > lh) lh = height[i];
                else trappedWater += lh - height[i];
                i++;
            } else {
                if (height[j] > rh) rh = height[j];
                else trappedWater += rh - height[j];
                j--;
            }
        }

        return trappedWater;
        
    }
}