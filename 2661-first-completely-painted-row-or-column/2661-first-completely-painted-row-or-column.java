class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> map = new HashMap();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m * n; i++) {
            int[] cur = map.get(arr[i]);

            if (++rows[cur[0]] == n || ++cols[cur[1]] == m) {
                return i;
            }
        }

        return -1;
    }
}