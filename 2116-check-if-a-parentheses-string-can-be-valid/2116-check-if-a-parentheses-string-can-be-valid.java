class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }

        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' && locked.charAt(i) == '1') {
                minOpen++;
                maxOpen++;
            } else if (c == ')' && locked.charAt(i) == '1') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if (minOpen < 0) {
                minOpen = 0;
            }

            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }
}