import java.io.*;
import java.util.*;

//백준 숨바꼭질 3
// dp로 풀려다가 대실패 ㅎㅎ;; 
class Location {
    int idx;
    int time;
    public Location (int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(n, 1));
        visited[n] = 1;

        while (!q.isEmpty()) {
            Location now = q.poll();

            // + 1
            if (now.idx + 1 >= 0 && now.idx + 1 <= 100000) {
                if (visited[now.idx + 1] == 0 || visited[now.idx + 1] > now.time + 1) {
                    visited[now.idx + 1] = now.time + 1;
                    q.add(new Location(now.idx + 1, now.time + 1));
                }
            }

            // - 1
            if (now.idx - 1 >= 0 && now.idx - 1 <= 100000) {
                if (visited[now.idx - 1] == 0 || visited[now.idx - 1] > now.time + 1) {
                    visited[now.idx - 1] = now.time + 1;
                    q.add(new Location(now.idx - 1, now.time + 1));
                }
            }

            // * 2
            if (now.idx * 2 >= 0 && now.idx * 2 <= 100000) {
                if (visited[now.idx * 2] == 0 || visited[now.idx * 2] > now.time) {
                    visited[now.idx * 2] = now.time;
                    q.add(new Location(now.idx * 2, now.time));
                }
            }
        }
        System.out.println(visited[k] - 1);
    }
}
