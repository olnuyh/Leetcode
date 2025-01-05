class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);

            cur.set(0, cur.get(0) + prev.get(0));

            for (int j = 1; j < cur.size() - 1; j++) {
                cur.set(j, cur.get(j) + Math.min(prev.get(j - 1), prev.get(j)));
            }

            int last = cur.size() - 1;
            cur.set(last, cur.get(last) + prev.get(last - 1));
        }

        List<Integer> bottom = triangle.get(triangle.size() - 1);

        int min = Integer.MAX_VALUE;

        for (int num : bottom) {
            min = Math.min(min, num);
        }

        return min;
    }
}