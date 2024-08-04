import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            q.add(a);
            visited[a] = true;
            Arrays.fill(command, "");

            while (!q.isEmpty()) {
                int now = q.poll();
                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;
                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    command[D] = command[now] + "D";
                }
                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }
                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[now] + 'R';
                }
                
            }
            System.out.println(command[b]);

        }
    }

}
