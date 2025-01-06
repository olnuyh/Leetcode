class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int prev = matrix[i - 1][j];

                if (j - 1 >= 0) {
                    prev = Math.min(prev, matrix[i - 1][j - 1]);
                }

                if (j + 1 < n) {
                    prev = Math.min(prev, matrix[i - 1][j + 1]);
                }

                matrix[i][j] += prev;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, matrix[n - 1][i]);
        }

        return answer;
    }
}