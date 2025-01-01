class Solution {
    public int climbStairs(int n) {
        int[] D = new int[n + 1];

        D[0] = 1;
        D[1] = 1;

        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 2] + D[i - 1];
        }

        return D[n];
    }
}