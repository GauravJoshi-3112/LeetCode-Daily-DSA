class Solution {
    public int myAtoi(String s) {
        int value = 0;
        boolean isNegative = false;
        int curr = 0;
        int maxValue = -1*(Integer.MIN_VALUE/10);

        // Skip Leading WhiteSpaces
        s = s.trim();

        // Handling Sign
        if (curr < s.length() && (s.charAt(curr) == '-' || s.charAt(curr) == '+')) {
            isNegative = s.charAt(curr) == '-' ? true : false;
            curr++;
        }

        while (curr < s.length() && s.charAt(curr) >= 48 && s.charAt(curr) <= 57) {
            
            if (value > (Integer.MAX_VALUE - (s.charAt(curr) - '0'))/10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } 
            value = value*10 + s.charAt(curr) - '0';
            curr++;
        }

        return isNegative ? -1*value : value;
    }
}