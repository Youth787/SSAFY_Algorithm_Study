//TSP
//가장 적은 비용을 들이는 여행 계획
//1번부터 N번까지 번호가 매겨져 있는 도시들. 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획
//비용은 행렬 W[i][j] 비용은 대칭적이지 않다. =단방향(?)
// W[i][i]는 항상 0, 도시 사이에 길이 없는 경우도 0
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean [] visited;
    static int[][] map;
    static long ans;//각 행렬의 성분은 1,000,000 이하의 양의 정수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ans = Integer.MAX_VALUE;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            DFS(i, i, 0);
        }
        System.out.println(ans);
    }//main

    public static void DFS(int start, int now, long cost){
        if (allVisited()) {//모든 도시를 다 방문했다면
            if(map[now][start]!=0){
                ans = Math.min(ans, cost + map[now][0]);
            }
            return;
        }

        //재귀
        for(int i=1; i<n; i++){
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                DFS(start, i, cost + map[now][i]);
                visited[i] = false;//빠꾸
            }
        }
    }//DFS

    //모든 도시 방문했는지 확인하는 메서드
    public static boolean allVisited() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }//도시 방문 확인
}//class
