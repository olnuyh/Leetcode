class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        
        int[] alpha = new int[26];

        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }   

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                count++;
            }
        }        

        return count <= k;
    }
}