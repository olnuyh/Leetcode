class Solution {
    private int[] state;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        state = new int[n];
        List<Integer> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i)) {
                list.add(i);
            }
        }

        return list;
    }

    public boolean isSafe (int[][] graph, int cur) {
        if (state[cur] > 0) {
            return state[cur] == 2;
        }

        state[cur] = 1;

        for (int next : graph[cur]) {
            if (state[next] == 1 || !isSafe(graph, next)) {
                return false;
            }
        }

        state[cur] = 2;
        return true;
    }
}