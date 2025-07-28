    import java.util.*;
    import java.io.*;

    public class Main {
        private static int v, e;
        private static ArrayList<ArrayList<Integer>> graph;
        private static int[] color;
        private static StringBuilder sb;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st;
            sb = new StringBuilder();

            a: for (int tc = 0; tc < k; tc++) {
                st = new StringTokenizer(br.readLine());
                v = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                graph = new ArrayList<>();
                color = new int[v + 1];
                for (int i = 0; i <= v; i++) {
                    graph.add(new ArrayList<>());
                }
                for (int i = 0; i < e; i++) {
                    st = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    graph.get(u).add(w);
                    graph.get(w).add(u);
                }
                solve();
            }
            System.out.println(sb);
        }
        private static void solve() {
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    color[i] = 1;
                    q.add(i);
                }
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int next: graph.get(now)) {
                        if (color[next] == color[now]) {
                            sb.append("NO").append("\n");
                            return;
                        }
                        if (color[next] == 0) {
                            q.add(next);
                            if (color[now] == 1) color[next] = 2;
                            else color[next] = 1;
                        }
                    }
                }
            }

            sb.append("YES").append("\n");
        }

    }
