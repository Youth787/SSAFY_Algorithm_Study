import java.util.*;

class Solution {
    public static int[] dx = {1, 0, 0, -1}; // d l r u 순서
    public static int[] dy = {0, -1, 1, 0};
    public static char[] dc = {'d', 'l', 'r', 'u'};
    public static int K, N, M;
    public static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        K = k;
        N = n;
        M = m;

        // 가능 불가능 판별
        if((Math.abs(x - r) + Math.abs(y - c)) % 2 != k % 2) return "impossible";
        if((Math.abs(x - r) + Math.abs(y - c)) > k) return "impossible";
        
        dfs(x - 1, y - 1, new StringBuilder(), 0, r - 1, c - 1);

        return answer.length() == 0 ? "impossible" : answer;
    }
    public static void dfs(int x, int y, StringBuilder sb, int cnt, int endX, int endY) {
        if (answer.length() != 0) return;
        if (x == endX && y == endY && cnt == K) {
            answer = sb.toString();
            return;
        }
        if (cnt >= K) return;
        int dist = Math.abs(x - endX) + Math.abs(y - endY);
        if (K - sb.length() < dist) return;
        
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
            sb.append(dc[i]);
            dfs(mx, my, sb, cnt + 1, endX, endY);
            sb.deleteCharAt(sb.length() - 1);
            
        }
        
    }
}
