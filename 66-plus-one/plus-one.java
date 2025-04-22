class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            if (carry + digits[i] >= 10) {
                digits[i] = (carry + digits[i]) % 10;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            int [] result = new int [digits.length+1];
            int count = 0;
            result[count++] = carry;
            for(int elem : digits) {
                result[count++] = elem;
            }
            return result;
        } 
        return digits;
    }
}