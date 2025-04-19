class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // target = 0;
        Set<List<Integer>> tripletSet = new HashSet<>();
        // Sort the Array
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            // Traversing Array Doing 2Sum for Every i value 
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    tripletSet.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(tripletSet);
    }
}