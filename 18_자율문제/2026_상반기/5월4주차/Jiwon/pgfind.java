import java.util.*;

class Solution {
    public static boolean[] visited;
    public static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int[] num = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) - '0';
        }
        for (int i = 1; i <= numbers.length(); i++) {
            visited = new boolean[num.length];
            dfs(num, 0, i, "");
        }


        return set.size();
    }
    public static void dfs(int[] num, int cnt, int max, String str) {
        if (cnt == max) {
            if (canMake(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(num, cnt + 1, max, str + num[i]);
            visited[i] = false;
        }

    }
    public static boolean canMake(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}