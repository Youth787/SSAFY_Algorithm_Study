import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String str = Long.toBinaryString(number);
            if (!str.contains("0")) {
                answer[i] = 1;
                continue;
            }
            if (str.length() == 1) {
                if (numbers[i] == 0) answer[i] = 0;
                continue;
            } else {
                str = makeTree(str);
            }
            if(!dfs(str, 0, str.length() - 1)) answer[i] = 1;
        }
        
        return answer;
    }
    public static boolean dfs(String str, int start, int end) {
        if (start >= end) {
            return false;
        }
        int root = (start + end) / 2;
        
        if (str.charAt(root) == '0') {
            for (int i = start; i <= end; i++) {
                if (str.charAt(i) == '1') return true;
            }
            return false;
        }
        
        boolean left = dfs(str, start, root - 1);
        boolean right = dfs(str, root + 1, end);
        
        return left || right;
        
        
        
    }
    public static String makeTree(String str) {
        int len = 1;
        
        while (str.length() > len) {
            len = len * 2 + 1;
        }
        StringBuilder sb = new StringBuilder();
        int zerolen = len - str.length();
        sb.append("0".repeat(zerolen));
        return sb.append(str).toString();
    }
}
