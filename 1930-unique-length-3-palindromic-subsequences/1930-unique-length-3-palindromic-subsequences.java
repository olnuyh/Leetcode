class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] left = new int[26];
        int[] right = new int[26];

        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        Set<Integer> set = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';

            right[k]--;

            for (int j = 0; j < 26; j++) {
                if (left[j] > 0 && right[j] > 0) {
                    set.add(26 * k + j);
                }
            }

            left[k]++;
        }

        return set.size();
    }
}