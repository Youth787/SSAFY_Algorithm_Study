import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;
    public int solution(int n, int[][] wires) {
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        int answer = Integer.MAX_VALUE;
        for (int[] now: wires) {
            list.get(now[0]).add(now[1]);
            list.get(now[1]).add(now[0]);
        }
        for (int[] now: wires) {
            visited = new boolean[n + 1];
            
            list.get(now[0]).remove(Integer.valueOf(now[1]));
            list.get(now[1]).remove(Integer.valueOf(now[0]));
            
            int cnt = dfs(1);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            list.get(now[0]).add(now[1]);
            list.get(now[1]).add(now[0]);
        }
        
        
        return answer;
    }
    public static int dfs(int x) {
        visited[x]  = true;
        int cnt = 1;
        for (int next: list.get(x)) {
            if (visited[next]) continue;
            cnt += dfs(next);
        }
        return cnt;
    }
}
