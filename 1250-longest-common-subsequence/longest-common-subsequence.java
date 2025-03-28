class Solution {
    int [][] dp;
    // public int LCS(String text1, String text2) {
    //     if (text1.length()==0 || text2.length()==0) return 0;
    //     if (text1.charAt(0) == text2.charAt(0)) return 1+LCS(text1.substring(1),text2.substring(1));
    //     else {
    //         int max1 = dp[text1.length()][text2.length()-1] != -1 ? dp[text1.length()][text2.length()-1] : LCS(text1,text2.substring(1));
    //         dp[text1.length()][text2.length()-1] = max1;
    //         int max2 = dp[text1.length()-1][text2.length()] != -1 ? dp[text1.length()-1][text2.length()] : LCS(text1.substring(1),text2);
    //         dp[text1.length()-1][text2.length()] = max2;
    //         dp[text1.length()][text2.length()] = Math.max(max1,max2);
    //     }
    //     return dp[text1.length()][text2.length()];
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length()+1; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<text2.length()+1; j++) {
            dp[0][j] = 0;
        }
        for(int i=1; i<text1.length()+1; i++) {
            for(int j=1; j<text2.length()+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}