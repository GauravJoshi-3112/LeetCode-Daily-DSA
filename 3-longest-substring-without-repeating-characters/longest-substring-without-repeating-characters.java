class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLength = 0;
        HashMap<Character,Integer> freqMap = new HashMap<>();

        while (end < s.length()) {
            // Travserse the Array
            while (end < s.length() && !freqMap.containsKey(s.charAt(end))) {
                freqMap.put(s.charAt(end),end);
                end++;
            }
            maxLength = Math.max(maxLength,end-start);
            while(end < s.length() && freqMap.containsKey(s.charAt(end))) {
                freqMap.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}