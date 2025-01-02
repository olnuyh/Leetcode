class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;

        int[] D = new int[n];

        for (int i = 2; i < n; i++) {
            D[i] = Math.min(D[i - 2] + cost[i - 2], D[i - 1] + cost[i - 1]);
        }

        return D[n - 1];
    }
}