class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int answer = 0;

        int n = nums1.length;
        int m = nums2.length;

        if (m % 2 == 1) {
            for (int num : nums1) {
                answer ^= num;
            }
        }

        if (n % 2 == 1) {
            for (int num : nums2) {
                answer ^= num;
            }
        }

        return answer;
    }
}