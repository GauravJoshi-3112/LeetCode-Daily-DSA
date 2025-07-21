class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        s = s.toLowerCase();
        t = t.toLowerCase();

        int [] freq = new int [26];

        for(int i = 0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
            freq[t.charAt(i) - 'a'] -= 1;
        }

        for(int i : freq) if (i != 0) return false;

        return true;
    }
}