class Solution {
    public int m, n;
    public int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int trapRainWater(int[][] heightMap) {
        int answer = 0;
        
        m = heightMap.length;
        n = heightMap[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>((pos1, pos2) -> pos1[0] -  pos2[0]);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    q.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[1] + deltas[d][0];
                int nc = cur[2] + deltas[d][1];

                if (!isIn(nr, nc) || visited[nr][nc]) {
                    continue;    
                }

                answer += Math.max(0, cur[0] - heightMap[nr][nc]);
                q.offer(new int[]{Math.max(cur[0], heightMap[nr][nc]), nr, nc});
                visited[nr][nc] = true;
            }
        }

        return answer;
    }

    public boolean isIn (int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}