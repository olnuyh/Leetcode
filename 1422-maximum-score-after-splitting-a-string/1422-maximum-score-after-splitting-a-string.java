class Solution {
    public int maxScore(String s) {
        int maxScore = 0;

        char[] nums = s.toCharArray();

        int totalOnes = 0;

        for (char num : nums) {
            if (num == '1') {
                totalOnes++;
            }
        }

        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }

            maxScore = Math.max(maxScore, zeros + (totalOnes - ones));
        }

        return maxScore;
    }
}