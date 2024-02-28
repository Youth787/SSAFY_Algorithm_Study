import java.io.*;
import java.util.*;


//n과 m (6)
public class Main {
    static int n, m;
    static int[] num, temp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        visited = new boolean[n];
        temp = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        solve(0, 0);

    }
    static void solve(int cnt, int idx) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }
        if (idx >= n) return;


                visited[idx] = true;
                temp[cnt] = num[idx];
                solve(cnt + 1, idx + 1);
                visited[idx] = false;
                solve(cnt, idx + 1);


    }
}
