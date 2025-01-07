class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(i, i + 1, s);
            String s2 = expand(i, i, s);

            if (answer.length() < s1.length()) {
                answer = s1;
            }

            if (answer.length() < s2.length()) {
                answer = s2;
            }
        }

        return answer;
    }

    public String expand (int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}