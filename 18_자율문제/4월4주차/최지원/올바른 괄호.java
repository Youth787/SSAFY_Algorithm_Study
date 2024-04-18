import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        ArrayDeque <Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
