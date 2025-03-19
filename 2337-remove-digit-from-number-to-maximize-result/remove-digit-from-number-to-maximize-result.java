class Solution {
    String maxNumber = "";
    public String removeDigit(String number, char digit) {
        for(int i=0; i<number.length(); i++) {
            if (number.charAt(i)==digit) {
               String numberFormed = number.substring(0,i)+number.substring(i+1);
                if (numberFormed.compareTo(maxNumber) > 0) maxNumber = numberFormed;
            }
        }
        return maxNumber;
    }
}