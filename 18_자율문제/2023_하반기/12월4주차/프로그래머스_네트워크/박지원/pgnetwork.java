import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            q.add(i);
            while (!q.isEmpty()) {
                int current = q.poll();
                visited[current] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && computers[current][j] == 1) {
                        q.add(j);
                    }
                }

            }
            answer++;
        }

        return answer;
    }
}
