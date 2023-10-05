
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] arr, ans;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[n];
        visited = new boolean[n];

        //n개 주어지는 수 새로 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        DFS(0);
        System.out.print(sb);
    }

    public static void DFS(int depth) {
        if (depth == m){
            for (int i = 0; i < m; i++){
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
            	//방문했다
                visited[i] = true;
                ans[depth] = arr[i];
                DFS(depth + 1);
                //방문 안했다 상태로 빠꾸
                visited[i] = false;
            }
        }
    }
}
