class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m denotes orignal length of array nums1
        int curr = nums1.length - 1; // curr denotes index of merged Array
        // Pointers to Traverse nums1, nums2
        int i = m-1, j = n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[curr--] = nums1[i];
                i--;
            } else {
                nums1[curr--] = nums2[j];
                j--;
            }
        }

        while (j >= 0) {
            nums1[curr--] = nums2[j];
            j--;
        }
        
    }
}