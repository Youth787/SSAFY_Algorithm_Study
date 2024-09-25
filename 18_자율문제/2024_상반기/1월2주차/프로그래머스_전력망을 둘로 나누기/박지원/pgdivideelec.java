import java.util.*;
class Solution {
    static int n, count1, count2, answer;
    static int[][] map;
    static boolean[] visited;
    
    public int solution(int N, int[][] wires) {
        n = N;
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            count1 = 0;
            count2 = 0;
            map = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                map[wires[j][0]][wires[j][1]] = map[wires[j][1]][wires[j][0]] = 1;
            }
            a: for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (count1 == 0) count1 = solve(j, 0);
                    else count2 = solve(j, 0);
                }
            }
            answer = Math.min(answer, Math.abs(count1 - count2));
        }
        return answer;
    }
    static int solve(int node, int cnt) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[i][cur] == 1) {
                    q.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

//wires에서 0~length-1씩 포문돌려서 한개씩 ㅂ빠트리기.
//그렇게해서 트리 노드 갯수세고 count1, count2에 저장해서 둘의 차이를 min에 저장
//그 후 포문 돌아가면서 다음 한개가 빠지고 다시 count1, count2 차이 구하고 최소값 비교해서 min저장
