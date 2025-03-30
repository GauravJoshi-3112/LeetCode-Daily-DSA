class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagram = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0; // Maintaining a Count Variable for Count purpose
        for(Character ch : p.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        count = map.size();
        int occur = 0;
        int windowSize = p.length();
        int j = 0;
        // Traversing the String
        for(int i=0; i<=s.length() - windowSize; i++) {
            // Check if j < i and j-i+1 < windowSize
            while (j<i || j-i+1 <= windowSize) {
                // if s.charAt(j) exists / does'nt exists in Map
                if (map.containsKey(s.charAt(j))) {
                    // Do Operation if Character exists in Map
                    // Reduce Occurence of character in map
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    if (map.get(s.charAt(j)) == 0) {
                        count--;
                    } 
                } 
                j++;
            }

            if (count == 0) {
                // This is anagram
                anagram.add(i);
            }

            if (map.containsKey(s.charAt(i))) {
                // Do Operation if Character exists in Map
                // Reduce Occurence of character in map
                if (map.get(s.charAt(i)) == 0) {
                    count++; // Character mismatch restored
                }
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }

        }

        return anagram;
    }
}