class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] S = new int[words.length + 1];
        S[0] = 0;

        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + ("aeiou".indexOf(words[i - 1].charAt(0)) >= 0 && "aeiou".indexOf(words[i - 1].charAt(words[i - 1].length() - 1)) >= 0 ? 1 : 0);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1] + 1;

            answer[i] = S[end] - S[start];
        }

        return answer;
    }
}