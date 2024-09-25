import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[][] price;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        price = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 끝

        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int cnt, int sum) {
        if (cnt == 3) {
            answer = Math.min(answer, sum);
        } else {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (!visited[i][j] && check(i, j)) {
                        visited[i][j] = true;
                        int total = sum(i, j);

                        dfs(cnt + 1, sum + total);

                        visitClear(i, j);
                        visited[i][j] = false;
                    }
                }
            }
        }

    }

    static boolean check(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) return false;
        }
        return true;
    }

    static void visitClear(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }

    static int sum(int x, int y) {
        int total = price[x][y];
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
            total += price[nx][ny];
        }
        return total;
    }
}


// https://hidelookit.tistory.com/198
