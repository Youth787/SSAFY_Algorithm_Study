import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

//플로이드 와샬 알고리즘(경찰과도둑!!!)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] friends = new int [n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                friends[i][j] = 987654321;
                if (i == j) friends[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = friends[b][a] = 1;
        } //입력 완.

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int res = 987654321;
        int idx = -1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += friends[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }

}
