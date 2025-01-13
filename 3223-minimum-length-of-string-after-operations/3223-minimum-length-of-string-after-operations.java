class Solution {
    public int minimumLength(String s) {
        if (s.length() < 3) {
            return s.length();
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int answer = s.length();

        for (int i = 0; i < 26; i++) {
            if (count[i] < 3) {
                continue;
            }

            if (count[i] % 2 == 0) {
                answer -= count[i] - 2;
            } else {
                answer -= count[i] - 1;
            }
        }

        return answer;
    }
}