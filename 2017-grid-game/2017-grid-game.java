class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long top = 0;

        for (int i = 0; i < n; i++) {
            top += grid[0][i];
        }

        long bottom = 0;
        long answer = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            top -= grid[0][i];
            answer = Math.min(answer, Math.max(top, bottom));
            bottom += grid[1][i];
        }

        return answer;
    }
}