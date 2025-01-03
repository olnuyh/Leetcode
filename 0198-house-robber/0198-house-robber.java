class Solution {
    public int rob(int[] nums) {
        int[] D = new int[nums.length + 2];

        for (int i = 2; i < D.length; i++) {
            D[i] = Math.max(D[i - 1], D[i - 2] + nums[i - 2]);
        }

        return D[D.length - 1];
    }
}