import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static boolean[] visited;
    public static ArrayList<Integer>[] map;
    public static void DFS(int n, int com){

        Queue<Integer> queue = new LinkedList<>();
        visited[com] = true;

        queue.add(com);

        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int i = 0; i < map[cur].size(); i++) {
                int next = map[cur].get(i);
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j){
                    map[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                DFS(n, i);
                answer++;
            }
        }

        return answer;
    }
}
