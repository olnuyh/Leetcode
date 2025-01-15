class Solution {
    public int minimizeXor(int num1, int num2) {
        int leftBit = Integer.bitCount(num2) - Integer.bitCount(num1);

        int cur = 1;

        while (leftBit != 0) {
            if (leftBit > 0 && (cur & num1) == 0) {
                num1 |= cur;
                leftBit--;
            } else if (leftBit < 0 && (cur & num1) > 0) {
                num1 ^= cur;
                leftBit++;
            }

            cur <<= 1;
        }

        return num1;
    }
}