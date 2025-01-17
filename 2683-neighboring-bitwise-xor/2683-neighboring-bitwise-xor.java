class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int answer = 0;

        for (int num : derived) {
            answer ^= num;
        }

        return answer == 0;
    }
}