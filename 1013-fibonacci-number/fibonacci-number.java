class Solution {
    // Doin it in Dynammic Way to Solve under O(N)
    public int fib(int n) {
        // Constraints 
        // n == 0 || n == 1
        if (n <= 1) return n;
        // Define 
        int f0 = 0, f1 = 1, fn = 0;
        // Run for loop till N
        for(int i=2; i<=n; i++) {
            fn = f1 + f0;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}