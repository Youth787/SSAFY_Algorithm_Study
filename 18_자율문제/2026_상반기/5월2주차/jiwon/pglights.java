import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        boolean[] lights = new boolean[n + 1];
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] graphs = new ArrayList[n + 1];
        
        lights[0] = false;
        visited[1] = true;
        
        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }
        
        for (int[] light: lighthouse) {
            graphs[light[0]].add(light[1]);
            graphs[light[1]].add(light[0]);
        }
        turnLight(1, 1, graphs, lights, visited);
        for (boolean lightOn: lights) if (lightOn) answer++;
        return answer;
    }
    public void turnLight(int cur, int parent, List<Integer>[] list, boolean[] lights, boolean[] visited) {
        //무방향 인접 리스트. parent가 포함되어있음
        //visited로 체크 가능
        for (int v: list[cur]) {
            if (!visited[v]) {
                visited[v] = true;
                turnLight(v, cur, list, lights, visited);
            }
            
        }
        //부모 제외한 자식 노드를 체크한다
        //리프노드인 경우에는 lights켜지않음
        boolean hasAnyChildOff = false;
        for (int v: list[cur]) {
            if (v == parent) continue;
            if (!lights[v]) {
                hasAnyChildOff = true;
                break;
            }
        }
        if (hasAnyChildOff) lights[cur] = true;
        
    }
}
