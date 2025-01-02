class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int[] D = new int[n + 1];
        D[0] = 0;
        D[1] = D[2] = 1;

        for (int i = 3; i <= n; i++) {
            D[i] = D[i - 3] + D[i - 2] + D[i - 1];
        }

        return D[n];
    }
}