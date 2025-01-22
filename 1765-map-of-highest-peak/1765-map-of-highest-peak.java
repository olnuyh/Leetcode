class Solution {
    public int m, n;
    public int[][] answer;
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public Queue<int[]> q;

    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;

        answer = new int[m][n];
        q = new ArrayDeque();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 0) {
                    answer[i][j] = Integer.MAX_VALUE;
                } else {
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs(isWater);

        return answer;
    }

    public void bfs (int[][] isWater) {
        int val = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (--size >= 0) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];

                    if (isIn(nr, nc) && isWater[nr][nc] == 0 && answer[nr][nc] > val) {
                        q.offer(new int[]{nr, nc});
                        answer[nr][nc] = val;
                    }
                }
            }

            val++;
        }
    }

    public boolean isIn (int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}