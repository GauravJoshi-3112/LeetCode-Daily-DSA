class Solution {
    public boolean isPalindrome(String s) {
        // Converting String into LowerCase
        s = s.toLowerCase();

        int i = 0, j = s.length()-1;

        while (i < j) {
            if (!(s.charAt(i) >= 97 && s.charAt(i) <= 122) && !(s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                i++;
                continue;
            }
            if (!(s.charAt(j) >= 97 && s.charAt(j) <= 122) && !(s.charAt(j) >= 48 && s.charAt(j) <= 57)) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}