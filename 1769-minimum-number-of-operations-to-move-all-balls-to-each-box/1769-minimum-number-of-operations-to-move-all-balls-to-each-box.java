class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        char[] arr = boxes.toCharArray();

        int[] left = new int[n];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == '1') {
                cnt++;
            }
            
            left[i] = left[i - 1] + cnt;
        }

        int[] right = new int[n];
        cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] == '1') {
                cnt++;
            }
            
            right[i] = right[i + 1] + cnt;
         }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] += left[i] + right[i];
        }
        
        return answer;
    }
}