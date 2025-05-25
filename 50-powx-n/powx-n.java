class Solution {
    public double myPowHelp(double x, long n) {
        if (n == 1) return x;
        if (n%2 == 0) return myPowHelp(x*x,n/2);
        else return x*myPowHelp(x*x,(n-1)/2);
    }

    public double myPow(double x, int N) {
        long n = N;
        if (n < 0) return 1/(myPowHelp(x,Math.abs(n)));
        else if (n == 0) return 1;
        else return myPowHelp(x,n);
    }

}