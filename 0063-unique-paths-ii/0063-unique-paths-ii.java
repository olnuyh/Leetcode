class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] D = new int[m][n];
        D[0][0] = obstacleGrid[0][0] == 0? 1 : 0;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                D[i][0] += D[i - 1][0];   
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                D[0][i] += D[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (obstacleGrid[i - 1][j] == 0) {
                    D[i][j] += D[i - 1][j];
                }

                if (obstacleGrid[i][j - 1] == 0) {
                    D[i][j] += D[i][j - 1];
                }
            }
        }

        return D[m - 1][n - 1];
    }
}