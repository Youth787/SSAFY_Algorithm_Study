import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static int n, m, tc;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc = 1;
        String str = "";
        while(!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n + 1];
            for(int r = 1; r <= n; r++){
                adj[r] = new ArrayList<>();
            }

            for(int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
                adj[to].add(from);
            }

            for(int r = 1; r <= n; r++) {
                Collections.sort(adj[r]);
            }

            visited = new boolean[n + 1];
            
            int treeCount = 0;
            for(int r = 1; r <= n; r++) {
                if(!visited[r] && !isC(r, 0)){ 
                  treeCount += 1;
                }
            }

            if(treeCount > 1) {
                sb.append(String.format("Case %d: A forest of %d trees.", tc, treeCount)).append("\n");
            } else if(treeCount == 1) {
                sb.append(String.format("Case %d: There is one tree.", tc)).append("\n");
            } else {
                sb.append(String.format("Case %d: No trees.", tc)).append("\n");
            }
            tc += 1;
        }
        System.out.println(sb);
    }//main

    static boolean isC(int r, int prev) {
        visited[r] = true;
        for(int c : adj[r]) {
            if(!visited[c]) {
                if(isC(c, r)) return true;
            } else if(c != prev) {
                return true;
            }
        }
        return false;
    }//isC 싸이클 있는지 없는지
}
