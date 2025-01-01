class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] D = new int[n + 1];

        D[0] = 0;
        D[1] = 1;

        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 2] + D[i - 1];
        }

        return D[n];
    }
}