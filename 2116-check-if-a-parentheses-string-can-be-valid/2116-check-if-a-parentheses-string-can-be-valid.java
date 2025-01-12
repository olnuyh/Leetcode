class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Integer> lock = new Stack();
        Stack<Integer> free = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char l = locked.charAt(i);
            
            if (l == '0') {
                free.push(i);
            } else {
                if (c == '(') {
                    lock.push(i);
                } else {
                    if (!lock.isEmpty()) {
                        lock.pop();
                    } else if (!free.isEmpty()) {
                        free.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        while (!lock.isEmpty() && !free.isEmpty() && lock.peek() < free.peek()) {
            lock.pop();
            free.pop();
        }

        if (lock.isEmpty() && free.size() % 2 == 0) {
            return true;
        }

        return lock.isEmpty();
    }
}