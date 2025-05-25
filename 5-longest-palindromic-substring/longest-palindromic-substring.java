class Solution {
    public String longestPalindrome(String s) {
        String maxPall = "";
        for(int i=0; i<s.length(); i++) {
            // Odd
            int left = i-1;
            int right = i+1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
            }

            if ((right - left)-1 > maxPall.length()) maxPall = s.substring(left+1,right);

            // Even
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
            } 

            if ((right - left)-1 > maxPall.length()) maxPall = s.substring(left+1,right);
        }
            
        return maxPall;
    }
}