class Solution {
    public int uniquePaths(int m, int n) {
        int[][] D = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            D[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            D[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                D[i][j] += D[i - 1][j] + D[i][j - 1];
            }
        }

        return D[m - 1][n - 1];
    }
}