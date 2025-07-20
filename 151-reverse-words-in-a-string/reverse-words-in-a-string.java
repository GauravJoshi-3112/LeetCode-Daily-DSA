class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();

        int j = s.length();

        for(int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ' && i == j-1) j--; 
            else if (s.charAt(i) == ' ')  {
                result.append(s.substring(i+1, j) + " ");
                j = i;
            }
        }

        if (j != 0) result.append(s.substring(0, j));

        return result.toString();

        
    }
}