class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] count = new int[n + 1];
        int[] answer = new int[n];

        int common = 0;

        for (int i = 0; i < n; i++) {
            if (++count[A[i]] == 2) {
                common++;
            }
            
            if (++count[B[i]] == 2) {
                common++;
            }

            answer[i] = common;
        }

        return answer;
    }
}