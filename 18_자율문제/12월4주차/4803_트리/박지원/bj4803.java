import java.sql.Array;
import java.util.*;
import java.io.*;
//그래프 및 트리공부 다시합시다
public class Main {
    static List<ArrayList<Integer>> graph;
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) { // 그래프 초기화
                graph.add(new ArrayList<>());
            }
            visited = new boolean[n + 1];

            for (int i = 0; i < m; i++) { // 그래프에 입력 넣어주기!
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            //입력 완료.

            int tree = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    tree += checkTree(i);
                }
            }
            sb.append("Case ").append(tc).append(": ");
            if (tree > 1) {
                sb.append("A forest of ").append(tree).append(" trees.");
            } else if (tree == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("No trees.");
            }
            sb.append("\n");
            tc++;
        }
        System.out.println(sb.toString());
    }
    static int checkTree(int root) {
        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        int edge = 0;

        q.add(root);
        while (!q.isEmpty()) {
            int current = q.poll();
            if (visited[current]) continue;
            visited[current] = true;
            node++;
            for (int i = 0; i < graph.get(current).size(); i++) {
                int nn = graph.get(current).get(i);
                edge++;
                if (!visited[nn]) q.add(nn);
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;
    }
}

//https://ksb-dev.tistory.com/113
