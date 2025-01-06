class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] D = new int[m + 1][n + 1];

        int answer = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i][j - 1], D[i - 1][j])) + 1;
                    answer = Math.max(answer, D[i][j]);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }

        return answer * answer;
    }
}