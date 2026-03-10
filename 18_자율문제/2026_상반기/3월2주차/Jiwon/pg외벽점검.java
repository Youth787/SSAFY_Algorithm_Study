import java.util.*;

class Solution {
    static int[] w;
    static boolean found;

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        w = new int[len * 2];

        for (int i = 0; i < len; i++) {
            w[i] = weak[i];
            w[i + len] = weak[i] + n;
        }

        // 임의1명, 2명, 3명 ... dist.length명까지 확인
        for (int r = 1; r <= dist.length; r++) {
            found = false; // r명일때 found 초기화

            for (int start = 0; start < len; start++) {
                dfs(start, 0, r, dist, new boolean[dist.length], new int[r], len);
                if (found) return r;
            }
        }

        return -1;
    }

    static void dfs(int start, int depth, int r, int[] dist, boolean[] visited, int[] permuted, int len) {
        if (found) return; // 이미 r명으로 가능한 경우를 찾았으면 중단

        if (depth == r) {
            if (check(start, start + len, permuted)) {
                found = true;
            }
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            permuted[depth] = dist[i];
            dfs(start, depth + 1, r, dist, visited, permuted, len);
            visited[i] = false;
        }
    }

    static boolean check(int start, int end, int[] permuted) {
        int friend = 0;
        int pos = w[start] + permuted[friend];

        for (int i = start; i < end; i++) {
            if (w[i] > pos) {
                friend++;
                if (friend >= permuted.length) return false;
                pos = w[i] + permuted[friend];
            }
        }

        return true;
    }
}