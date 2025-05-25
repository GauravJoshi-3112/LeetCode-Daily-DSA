class Solution {
    public boolean isPalindrome(String str) {
        int i=0, j=str.length() - 1;
        while(i <= j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                count  = count + words[i].length()*2;
                if (map.get(words[i]) == 1) map.remove(words[i]);
                else map.put(words[i],map.get(words[i])-1);
            } else {
                String reversed = new StringBuilder(words[i]).reverse().toString();
                map.put(reversed,map.getOrDefault(reversed,0)+1);
            }
        }

        // Find Max Length Freq
        int max = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getKey().length() > max) {
                if (isPalindrome(entry.getKey())) max = entry.getKey().length();
            }
        }

        return max + count;

    }
}