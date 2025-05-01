class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int current = 0;
        int prev_1 = cost[1];
        int prev_2 = cost[0];

        for(int i=2; i<=cost.length; i++) {
            if (i == cost.length) return Math.min(prev_1,prev_2);
            current = Math.min(prev_1,prev_2) + cost[i];
            prev_2 = prev_1;
            prev_1 = current;
        }

        return prev_1;
        
    }
}