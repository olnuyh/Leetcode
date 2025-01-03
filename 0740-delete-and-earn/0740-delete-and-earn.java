class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] D = new int[max + 1];

        for (int num : nums) {
            D[num] += num;
        }

        for (int i = 2; i < D.length; i++) {
            D[i] = Math.max(D[i - 1], D[i - 2] + D[i]);
        }

        return D[max];
    }
}