class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Traversing and Maintaining and creating a frequency array
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        // Creating answer ArrayList
        List<Integer> list = new ArrayList<>();
        int kN = k;
        while(k > 0) {
            int maxFreq = 0;
            List<Integer> bucket = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    bucket = new ArrayList<>();
                    bucket.add(entry.getKey());
                } else if (entry.getValue() == maxFreq) {
                    bucket.add(entry.getKey());
                }
            }
            
            for(int i=0; i<bucket.size(); i++) {
                int elem = bucket.get(i);
                list.add(elem);
                freqMap.remove(elem);
            }

            k--;
        }

        return list.stream().mapToInt(Integer::intValue).limit(kN).toArray();

    }
}