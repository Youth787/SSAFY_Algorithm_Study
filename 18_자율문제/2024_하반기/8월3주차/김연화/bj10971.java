import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int cost;
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        cost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            solve(i, i, 0, 0);
        }

        bw.write(cost + "");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void solve(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                cost = Math.min(cost, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                solve(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}
