class Solution {
    public int m, n;
    public int[][] deltas = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        visited[0][0] = 0;

        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int dir = grid[cur[0]][cur[1]];

            for (int d = 1; d <= 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc)) {
                    int val = visited[cur[0]][cur[1]] + (dir == d? 0 : 1);

                    if (visited[nr][nc] > val) {
                        q.offer(new int[] {nr, nc});
                        visited[nr][nc] = val;
                    }
                }
            }
        }

        return visited[m - 1][n - 1];
    }

    public boolean isIn (int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}