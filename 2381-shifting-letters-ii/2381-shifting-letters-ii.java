class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] move = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            if (dir == 0) {
                dir = -1;
            }

            move[start] += dir;
            move[end + 1] -= dir;
        }

        for (int i = 1; i < move.length; i++) {
            move[i] += move[i - 1];
        }

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < move.length; i++) {
            if (move[i] == 0) {
                continue;
            }

            char cur = sb.charAt(i);

            sb.setCharAt(i, (char)(((cur - 'a' + move[i]) % 26 + 26) % 26 + 'a'));
        }

        return sb.toString();
    }
}