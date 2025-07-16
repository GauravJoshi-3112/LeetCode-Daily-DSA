class Solution {
    public int findNextGreater(int [] nums2, int index) {
        for(int i = index+1; i<nums2.length; i++) {
            if (nums2[i] > nums2[index]) return nums2[i];
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i=0; i<nums1.length; i++) {
            int elem = nums1[i];
            int j = 0;
            for(j=0; j<nums2.length; j++) if (nums2[j] == nums1[i]) break;
            int nextIndex = findNextGreater(nums2, j);
            nums1[i] = nextIndex;
        }

        return nums1;
    }
}