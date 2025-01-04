class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        for (char c : set) {
            int first = s.indexOf(c);
            int end = s.lastIndexOf(c);

            if (end - first + 1 >= 3) {
                String str = s.substring(first + 1, end);

                Set<Character> temp = new HashSet();

                for (char cc : str.toCharArray()) {
                    temp.add(cc);
                }

                count += temp.size();
            }
        }

        return count;
    }
}