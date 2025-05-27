class Solution {
    public int differenceOfSums(int n, int m) {
        // This Problem can also be achieved in O(1) complexity 
        // Identify the sum of n 
        int sumN = (n*(n+1))/2;

        // Found the Sum of n Natural Number such that divisible by m
        int k = n/m;
        int num2 = (m)*(k*(k+1))/2;

        // Found num1 
        int num1 = sumN - num2;

        return num1 - num2;
    }
}