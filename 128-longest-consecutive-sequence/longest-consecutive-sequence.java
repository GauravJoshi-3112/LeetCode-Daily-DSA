class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxSeqLength = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int elem : set) {
            // Check if its a Start of a Sequence 
            if (!set.contains(elem-1)) {
                // This is a Start of Sequence
                int index = 1;
                while (set.contains(elem + index)) index++; 
                maxSeqLength = Math.max(index,maxSeqLength);
            }
        }

        return maxSeqLength;

    }
}